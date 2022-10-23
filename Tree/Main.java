/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.binarytree;

/**
 *
 * @author musasina
 */
public class Main {
    public static void main(String[] args) {
        /*BinaryTree bt = new BinaryTree();
        bt.insert(5);
        bt.insert(4);
        bt.insert(7);
        bt.insert(8);
        bt.insert(6);
        bt.insert(9);

        bt.insert(10);
        //bt.delete(7);
        
        //bt.printTree();
        //System.out.println(bt.nodeCountWithStack());
        //System.out.println(bt.nodeCountWithQueue());
        //System.out.println(bt.height());
        bt.root = bt.stabilizer(bt.root);
        //System.out.println(bt.height());
        bt.postorder();*/
        
        ExperessionTree et = new ExperessionTree();
        et.buildTree("12+3*");
        et.postOrder(et.root);
        
    }
}
