/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.binarytree;

/**
 *
 * @author musasina
 */
public class Node<AnyType> {
    AnyType data;
    Node<AnyType> next;
    public Node(AnyType data){
        this.data = data;
        next = null;
}
}
