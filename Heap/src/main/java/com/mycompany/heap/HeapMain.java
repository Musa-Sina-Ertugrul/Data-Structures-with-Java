/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.heap;

/**
 *
 * @author musasina
 */
public class HeapMain {
    public static void main(String[] args) {
        Heap myHeap = new Heap(5);
        
        myHeap.insert(5);
        myHeap.insert(6);
        myHeap.insert(3);
        myHeap.insert(11);
        myHeap.insert(2);
        
        myHeap.printList();
        myHeap.extractMin();
        myHeap.printList();
    }
}
