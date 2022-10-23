/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.linked_list;

/**
 *
 * @author musasina
 */
public class DoubleNode<T> {
    
    T data;
    DoubleNode<T> next;
    DoubleNode<T> previous;
    
    public DoubleNode(T data){
        this.data = data;
        next = null;
        previous = null;
    }
}
