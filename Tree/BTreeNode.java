/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cseproject;

/**
 *
 * @author musasina
 */
public class BTreeNode<AnyType> {
    Integer[] arrayNum;
    int index;
    boolean leaf;
    BTreeNode[] arrayChildren;
    
    public BTreeNode(int T){
        this.arrayNum = new Integer[T];
        this.arrayChildren = new BTreeNode[T];
        this.index = 0;
        this.leaf = true;
    }
}
