/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.graph;

/**
 *
 * @author musasina
 */
public class Queuell<AnyType> {
    Node<AnyType> head;
    Node<AnyType> tail;
    int count;
    public Queuell(){
        this.head = null;
        this.tail = null;
        this.count = 0;
    }
    void enqueue(Node node){
        if(this.head == null){
            this.head = node;
            this.tail = node;
        }else{
            node.next=head;
            head=node;
        }
        count++;
    }
    Node<AnyType> dequeue(){
        if(this.head == this.tail){
            Node tmp = this.head;
            this.head = null;
            this.tail = null;
            return tmp;
        }else{
            Node<AnyType> tmp = this.head;
            Node<AnyType> previous = null;
            while(tmp.next != null){
                previous = tmp;
                tmp = tmp.next;
            }
            previous.next = null;
            tail = previous;
            return tmp;
        }
    }
    boolean isEmpty(){
        return this.head == null;
    }
    
    boolean search(int value){
        Node<Integer> tmp = (Node<Integer>) this.head;
        while(tmp != null){
            if(tmp.data == value)
                return true;
            tmp = tmp.next;
        }
        return false;
    }
    int howMany(int value){
        int[] array = new int[this.count];
        int count = 0;
        Node<Integer> tmp = (Node<Integer>) this.head;
        while(tmp != null){
            if(tmp.data==value)
                count++;
            tmp = tmp.next;
        }
        return count;
    }
}
