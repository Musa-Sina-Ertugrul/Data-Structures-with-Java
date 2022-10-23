/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.binarytree;

/**
 *
 * @author musasina
 */
public class Stackll<AnyType> {
    Node<AnyType> top;
    int count;
    public Stackll(){
        this.top = null;
        this.count = 0;
    }
    
    void push(Node node){
        if(this.count==0||this.top== null){
            this.top = node;
        }else{
            node.next=top;
            top = node;
        }
        count++;
    }
    Node pop(){
        Node tmp;
        if(this.count == 0 || this.top == null){
            return null;
        }else{
            tmp = top;
            top = top.next;
            count--;
            return tmp;
        }
    }
    Node peek(){
        if(this.count == 0 || this.top == null){
            return null;
        }else{
            return top;
        }
    }
    boolean isEmpty(){
        return this.count == 0;
    }
}
