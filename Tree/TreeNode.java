/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.binarytree;

/**
 *
 * @author musasina
 */
public class TreeNode<AnyType> {

    AnyType data;
    TreeNode<AnyType> right;
    TreeNode<AnyType> left;

    public TreeNode(AnyType data) {
        this.data = data;
        this.right = null;
        this.left = null;
    }

    TreeNode<AnyType> iterativeMinSearch() {
        TreeNode<AnyType> tmp;
        tmp = this;
        while (tmp.left != null) {
            tmp = tmp.left;
        }
        return tmp;
    }
    TreeNode<AnyType> iterativeMaxSarch() {
        TreeNode<AnyType> tmp;
        tmp = this;
        while (tmp.right != null) {
            tmp = tmp.right;
        }
        return tmp;
    }
    TreeNode<AnyType> iterativeSecondMaxSarch() {
        TreeNode<AnyType> tmp,previous;
        previous = null;
        tmp = this;
        while (tmp.right != null) {
            previous = tmp;
            tmp = tmp.right;
        }
        return previous;
    }
    
    TreeNode<AnyType> iterativeSecondSearch() {
        TreeNode<AnyType> tmp,previous;
        previous = null;
        tmp = this;
        while (tmp.left != null) {
            previous = tmp;
            tmp = tmp.left;
        }
        return tmp;
    }

}
