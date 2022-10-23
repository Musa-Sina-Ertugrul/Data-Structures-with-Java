/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.linked_list;

/**
 *
 * @author musasina
 */
public class CircularList<T> {
    
    DoubleNode<T> first;
    DoubleNode<T> last;
    
    public CircularList(){
        this.first = null;
        this.last = null;
    }
    
    void insertFirst(DoubleNode<T> newNode){
        if(this.first == null){
            this.first = newNode;
            this.last = newNode;
        }
        else{
            newNode.next = this.first;
            newNode.previous = this.last;
            this.first.previous = newNode;
            this.last.next = newNode;
            this.first = newNode;
        }
        
    }
    
    void deleteFirst(){
        if( this.first.equals(this.last)){
            this.first = null;
            this.last = null;
        }
        else{
            this.last.next = this.first.next;
            this.first.next.previous = this.last;
            this.first = this.first.next;
        }
    
    }
}
