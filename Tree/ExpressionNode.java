/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.binarytree;

/**
 *
 * @author musasina
 */
public class ExpressionNode {
    String data;
    ExpressionNode left;
    ExpressionNode right;
    
    public ExpressionNode(String data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
    
    void insert(ExpressionNode node){
        if(this.left == null){
            this.left = node;
        }else if(this.left !=null&&this.right == null){
            this.right = node;
        }
    }
}
