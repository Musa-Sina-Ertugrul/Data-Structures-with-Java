/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.binarytree;

/**
 *
 * @author musasina
 */
public class BTree<AnyType> {

    BTreeNode root;
    int T;

    public BTree(int T) {
        this.T = T;
        this.root = null;
    }

    void insert(BTreeNode<Integer> node, Integer value) {
        if (value == null) {
            return;
        }
        BTreeNode<Integer> tmp;
        BTreeNode<Integer> prevTmp = null;
        int indexConnection = 0;
        if (this.root == null) {
            tmp = new BTreeNode(this.T);
            this.root = tmp;
        } else {
            if (node == null) {
                tmp = this.root;
            } else {
                tmp = node;
            }
            int count = 0;
            if (tmp != node) {
                while (!tmp.leaf) {
                    prevTmp = tmp;
                    indexConnection = this.indexFinder(tmp, value);
                    tmp = tmp.arrayChildren[indexConnection];
                }
            }
        }
        if (tmp == null && this.root == tmp) {
            tmp = tmp.arrayChildren[indexConnection];
        }
        int indexShift = this.indexFinder(tmp, value);
        if (indexShift != this.T - 1) {
            tmp.arrayNum = this.shifter(tmp, value);
            tmp.arrayNum[indexShift] = value;
        } else {
            tmp.arrayNum[indexShift] = value;
        }
        tmp.index++;
        if (prevTmp == null && tmp.index == this.T) {
            this.root = this.breaker(null);
        } else if (prevTmp != null && tmp.index == this.T) {
            int index = 0;
            while (prevTmp.arrayChildren[index] != tmp) {
                index++;
            }
            prevTmp = this.breaker(tmp);
        }

    }

    MultiReturn searchNode(int value) {
        BTreeNode<Integer> tmp = this.root;
        BTreeNode<Integer> prevTmp = null;
        int indexConnection = 0;
        while (!tmp.leaf) {
            prevTmp = tmp;
            indexConnection = this.indexFinder(tmp, value);
            tmp = tmp.arrayChildren[indexConnection];
        }
        MultiReturn multi = new MultiReturn();
        multi.index = indexConnection;
        multi.node = prevTmp;
        return multi;
    }

    BTreeNode<Integer> breaker(BTreeNode<Integer> node) {
        MultiReturn multi;
        Integer value = null;
        if (node != null) {
            value = node.arrayNum[(this.T - 1) / 2];
            multi = this.searchNode(value);
        } else {
            value = this.root.arrayNum[(this.T - 1) / 2];
            multi = null;
        }
        BTreeNode<Integer> tmp;
        BTreeNode<Integer> prevTmp;
        BTreeNode<Integer> newTmp = new BTreeNode(this.T);
        if (multi != null && multi.node != null) {
            tmp = multi.node.arrayChildren[multi.index];
            prevTmp = multi.node;
            prevTmp.leaf = false;
            this.insert(prevTmp, value);
        } else {
            tmp = this.root;
            prevTmp = new BTreeNode(this.T);
            prevTmp.leaf = false;
            this.insert(prevTmp, value);
        }
        int index = ((this.T - 1) / 2) + 1;
        newTmp.arrayNum = tmp.arrayNum.clone();
        for (int i = 0; i < index - 1; i++) {
            newTmp.arrayNum[i] = newTmp.arrayNum[index + i];
        }
        for (int i = (this.T - 1) / 2; i < newTmp.arrayNum.length; i++) {
            tmp.arrayNum[i] = null;
        }
        for (int i = index - 1; i < newTmp.arrayNum.length; i++) {
            newTmp.arrayNum[i] = null;
        }
        if (multi != null) {
            prevTmp.arrayChildren[multi.index + 1] = newTmp;
            prevTmp.arrayChildren[multi.index] = tmp;
        } else {
            prevTmp.arrayChildren[1] = newTmp;
            prevTmp.arrayChildren[0] = tmp;
        }
        newTmp.index = (this.T - 1) / 2;
        tmp.index = (this.T - 1) / 2;
        newTmp.leaf = true;
        tmp.leaf = true;
        return prevTmp;
    }

    int indexFinder(BTreeNode<Integer> node, int value) {
        int index = 0;
        if (node.arrayNum[index] != null) {
            while (value > (Integer) node.arrayNum[index]) {
                index++;
                if (index == this.T - 1) {
                    break;
                }
                if (node.arrayNum[index] == null) {
                    break;
                }

            }
        }
        return index;
    }

    Integer[] shifter(BTreeNode<Integer> node, int value) {
        int index = 0;
        while (node.arrayNum[index] != null && node.arrayNum[index] < value) {
            index++;
        }
        Integer tmpNext = null;
        Integer tmp = node.arrayNum[index];
        node.arrayNum[index] = null;
        for (int i = index; i < this.T - 1; i++) {
            tmp = node.arrayNum[i];
            node.arrayNum[i] = tmpNext;
            tmpNext = node.arrayNum[i + 1];
            node.arrayNum[i + 1] = tmp;
        }
        node.arrayNum[this.T - 1] = tmpNext;
        return node.arrayNum;
    }

    void display(BTreeNode<Integer> node) {
        if (node == null) {
            return;
        }
        for (int i = 0; i < node.index; i++) {
            System.out.print(node.arrayNum[i]);
        }
        System.out.println("");
        if (node.leaf) {
            return;
        }
        for (int i = 0; i < node.index + 1; i++) {
            this.display(node.arrayChildren[i]);
        }
    }

}
