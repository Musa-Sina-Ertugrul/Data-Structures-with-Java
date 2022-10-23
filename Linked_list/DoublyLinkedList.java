/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.linked_list;

/**
 *
 * @author musasina
 */
public class DoublyLinkedList<T> {
    
    DoubleNode<T> first;
    DoubleNode<T> last;
    
    public DoublyLinkedList(){
        
        first = null;
        last = null;
    }
    
    void insertFirst(DoubleNode<T> newNode){
        
        if(this.first == null){
            this.first = newNode;
            this.last = newNode;
        }
        else{
            this.first.previous = newNode;
            newNode.next = this.first;
            this.first = newNode;
        }
        
    }
    
    void insertLast(DoubleNode<T> newNode){
        
        if(this.first == null){
            this.first = newNode;
            newNode.previous = last;
        }
        else{
            this.last.next = newNode;
            newNode.previous = this.last;
        }
        this.last = newNode;
    }
    
    void insertMiddle(DoubleNode<T> newNode, DoubleNode<T> previousNode){
    
        newNode.previous = previousNode;
        newNode.next = previousNode.next;
        previousNode.next.previous = newNode;
        previousNode.next = newNode;
    }
    
    void deleteFirst(){
        if(this.first == this.last){
            this.first = null;
            this.last = null;
        }
        else{
            this.first = this.first.next;
            this.first.previous = null;
            }
    }
    
    void deleteLast(){
        if(this.last == this.first){
            this.first = null;
            this.last = null;
        }
        else{
            this.last = this.last.previous;
            this.last.next = null;
        }
    }
    
    void deleteMiddle(DoubleNode<T> s){
    
        s.previous.next = s.next;
        s.next.previous = s.previous;
    }
    
    void swap(DoubleNode node1, DoubleNode node2){
        DoubleNode<T> tmp_p = node1.previous;
        DoubleNode<T> tmp_n = node1.next;
        node2.previous.next = node1;
        node1.previous = node2.previous;
        node1.next = node2.next;
        node2.next.previous = node1;
        tmp_p.next = node2;
        tmp_n.previous = node2;
        node2.next = tmp_n;
        node2.previous = tmp_p;
        
    
    }
    
    
}
