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
        /*bTree.insert(null, 5);
        bTree.insert(null, 6);
        bTree.insert(null, 7);
        bTree.insert(null, 8);
        bTree.insert(null, 9);
        bTree.insert(null, 10);
        bTree.insert(null, 11);
        bTree.insert(null, 12);
        bTree.insert(null, 1);
        bTree.insert(null, 2);
        bTree.insert(null, 3);
        bTree.insert(null, 4);
        bTree.insert(null, 13);
        bTree.insert(null, 14);
        bTree.insert(null, 15);
        bTree.insert(null,16);
        bTree.insert(null, 17);
        bTree.insert(null, 18);
        bTree.display(bTree.root,0);*/
        Integer[] array = {5,6,4,8,10,22,35,46,15,52};
        array = bTree.sort(array);
        for(int i = 0; i< array.length;i++){
            System.out.print(" "+array[i]);
        }
    }
}
