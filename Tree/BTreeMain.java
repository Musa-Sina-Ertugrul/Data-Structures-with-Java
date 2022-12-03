/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.binarytree;

/**
 *
 * @author musasina
 */
public class BTreeMain {

    public static void main(String[] args) {
        BTree bTree = new BTree(5);
        bTree.insert(null, 5);
        bTree.insert(null, 6);
        bTree.insert(null, 7);
        bTree.insert(null, 8);
        bTree.insert(null, 9);
        bTree.insert(null, 10);
        bTree.insert(null, 11);
        bTree.insert(null, 12);


        bTree.display(bTree.root);
    }
}
