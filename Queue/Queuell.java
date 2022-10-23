/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.queue;

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
        if(this.head == null){
            return null;
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
        return count == 0;
    }
}
