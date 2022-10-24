/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hashtable;

/**
 *
 * @author musasina
 */
public class Node<T> {
    T data;
    Node next;
    
    public Node(T data){
        this.data = data;
        next = null;
    }    
}
