/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.linked_list;

/**
 *
 * @author musasina
 */
public class Main {
    public static void main(String[] args) {
        DoubleNode n1 = new DoubleNode<>(1);
        DoubleNode n2 = new DoubleNode<>(2);
        DoubleNode n3 = new DoubleNode<>(2);
        DoubleNode n4 = new DoubleNode<>(3);
        DoubleNode n5 = new DoubleNode<>(4);
        DoubleNode n6 = new DoubleNode<>(4);
        
        DoublyLinkedList dl1 = new DoublyLinkedList<>();
        DoublyLinkedList dl2 = new DoublyLinkedList<>();
        
        DoubleNode[] arr1 = {n1,n2,n3,n4,n5,n6};
        DoubleNode[] arr2 = {n3,n4};
        
        for(int i = 0; i<arr1.length;i++){
            dl1.insertFirst(arr1[i]);
            
        }
        for(int i = 0; i<arr2.length;i++){
            
            dl2.insertFirst(arr2[i]);
        }
        
        
        
    }
}
