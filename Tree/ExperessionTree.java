/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.binarytree;

import java.util.ArrayList;

/**
 *
 * @author musasina
 */
public class ExperessionTree<AnyType> {

    ExpressionNode root;

    public ExperessionTree() {
        this.root = null;
    }

    void buildTree(String text) {
        Stackll<ExpressionNode> stack = new Stackll();
        ExpressionNode tmp1;
        ExpressionNode tmp2;
        ExpressionNode tmp3;
        for (int i = 0; i < text.length() - 1; i++) {
            if (!this.isOperator(text.substring(i, i + 1))) {
                stack.push(new Node(new ExpressionNode(text.substring(i, i + 1))));
            } else {
                tmp1 = (ExpressionNode) stack.pop().data;
                tmp2 = (ExpressionNode) stack.pop().data;
                tmp3 = new ExpressionNode(text.substring(i, i + 1));
                tmp3.left = tmp1;
                tmp3.right = tmp2;
                stack.push(new Node(tmp3));

            }
        }
        tmp1 = (ExpressionNode) stack.pop().data;
        tmp2 = (ExpressionNode) stack.pop().data;
        tmp3 = new ExpressionNode(text.substring(text.length() - 1));
        tmp3.left = tmp1;
        tmp3.right = tmp2;
        this.root = tmp3;
    }
    
    void postOrder(ExpressionNode node){
        if(node.left != null){
            this.postOrder(node.left);
        }if(node.right != null){
            this.postOrder(node.right);
        }
        System.out.print(node.data);
    }

    boolean isOperator(String text) {
        switch (text) {
            case "*":
                return true;
            case "+":
                return true;
            case "-":
                return true;
            case "/":
                return true;
            default:
                return false;
        }
    }

}
