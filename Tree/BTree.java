/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cseproject;

import java.util.ArrayList;

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

    // this method inserts elements when there is no breaking and when node is not null
    // this method insert element just in paremater node
    void insert(BTreeNode<Integer> node, Integer value) {
        if (value == null) {
            return;
        }
        BTreeNode<Integer> tmp;
        BTreeNode<Integer> prevTmp = null;
        int indexConnection = 0;
        // this part finds way
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
        // this part find index for element if it needs they shift other elements
        int indexShift = this.indexFinder(tmp, value);
        if (indexShift != this.T - 1) {
            tmp.arrayNum = this.shifter(tmp, value);
            tmp.arrayNum[indexShift] = value;
        } else {
            tmp.arrayNum[indexShift] = value;
        }
        tmp.index++;
        // this part checking conditations for breaking method
        if (prevTmp == null && tmp.index == this.T) {
            this.root = this.breaker(null);
        } else if (prevTmp != null && tmp.index == this.T) {
            int index = 0;
            while (prevTmp.arrayChildren[index] != tmp) {
                index++;
            }
            if (prevTmp == this.root) {
                prevTmp = this.breaker(tmp);
            } else {
                MultiReturn multi = new MultiReturn();
                multi = this.searchNode(prevTmp.arrayNum[0]);
                multi.node.arrayChildren[multi.index] = this.breaker(tmp);
            }
        }

    }

    // this find previous node, index of node andd index
    // I used object to return more variables etc.
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

    // this method breake node create new nodes and attach them to btree
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
        // this part checks is node equeal root node
        if (multi != null) {
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
        // this part re insert and delete necessery items
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
        // this part checks conditations for seperatation
        if (multi != null) {
            // this part is for node has enough place to insert new node to last index
            if (multi.index + 1 < this.T && prevTmp.arrayChildren[multi.index + 1] == null) {
                prevTmp.arrayChildren[multi.index + 1] = newTmp;
                // this part is for node has enough place to insert new node to not last index
            } else if (multi.index + 1 < this.T && prevTmp.arrayChildren[multi.index + 1] != null) {
                // this part makes decision to shift new element to right of old element or left of old element
                BTreeNode<Integer> tmpShift = null;
                BTreeNode<Integer> prevTmpShift = null;
                for (int i = multi.index; i < prevTmp.index - 1; i++) {
                    prevTmpShift = prevTmp.arrayChildren[i];
                    prevTmp.arrayChildren[i] = tmpShift;
                    tmpShift = prevTmp.arrayChildren[i + 1];
                    prevTmp.arrayChildren[i + 1] = prevTmpShift;
                }
                if (tmp.arrayNum[0] > newTmp.arrayNum[0]) {
                    prevTmp.arrayChildren[prevTmp.index] = tmpShift;
                    prevTmp.arrayChildren[multi.index + 1] = tmp;
                    prevTmp.arrayChildren[multi.index] = newTmp;
                } else if (tmp.arrayNum[0] < newTmp.arrayNum[0]) {
                    prevTmp.arrayChildren[prevTmp.index] = tmpShift;
                    prevTmp.arrayChildren[multi.index + 1] = newTmp;
                    prevTmp.arrayChildren[multi.index] = tmp;
                }
            } else {
                // this part is for breaking full node and creating new node which has leafs etc.
                multi = this.searchNode(tmp.arrayNum[0]);
                prevTmp = multi.node.arrayChildren[multi.index];
                prevTmp.arrayChildren[(this.T - 1) / 2] = newTmp;
                prevTmp.index = (this.T - 1) / 2;
                prevTmp.leaf = false;
            }
        } else {
            // this part making new root node and attach it to new mid leaf
            prevTmp.arrayChildren[1] = newTmp;
            prevTmp.arrayChildren[0] = tmp;
            BTreeNode[] tmpShift = new BTreeNode[(this.T - 1) / 2];
            int indexShift = 0;
            for (int i = ((this.T - 1) / 2) + 1; i < this.T; i++) {
                newTmp.arrayChildren[indexShift] = tmp.arrayChildren[i];
                index++;
                tmp.arrayChildren[i] = null;
            }
        }
        newTmp.index = (this.T - 1) / 2;
        tmp.index = (this.T - 1) / 2;
        return prevTmp;
    }
    // this part find index for number
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
    // this part shifts numbers
    Integer[] shifter(BTreeNode<Integer> node, int value) {
        int index = 0;
        while (node.arrayNum[index] != null && node.arrayNum[index] < value) {
            index++;
        }
        Integer tmpNext = null;
        Integer tmp = node.arrayNum[index];
        for (int i = index; i < node.index - 1; i++) {
            tmp = node.arrayNum[i];
            node.arrayNum[i] = tmpNext;
            tmpNext = node.arrayNum[i + 1];
            node.arrayNum[i + 1] = tmp;
        }
        node.arrayNum[node.index] = tmpNext;
        return node.arrayNum;
    }

    void display(BTreeNode<Integer> node, int level) {
        if (node == null) {
            return;
        }
        for (int i = 0; i < node.index; i++) {
            System.out.print(node.arrayNum[i]);
        }
        System.out.println(" level " + String.valueOf(level));
        if (node.leaf) {
            return;
        }
        level++;
        for (int i = 0; i < node.index + 1; i++) {
            this.display(node.arrayChildren[i], level);
        }
    }

    private void insertArray(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            this.insert(null, array[i]);
        }
    }
    // this part adds number of btree to arraylist
    private ArrayList<Integer> sortedArray(BTreeNode<Integer> node, ArrayList<Integer> array) {
        if (node == null) {
            return array;
        }
        for (int i = 0; i < node.index + 1; i++) {
            this.sortedArray(node.arrayChildren[i], array);
            if (!node.leaf && node.arrayNum[i] != null) {
                array.add(node.arrayNum[i]);
            }
        }
        for (int i = 0; i < node.index; i++) {
            if (node.leaf) {
                array.add(node.arrayNum[i]);
            }
        }
        if (node.leaf) {
            return array;
        }
        return array;
    }

    private Integer[] listArrayConverter(ArrayList<Integer> arrayList) {
        Integer[] array = new Integer[arrayList.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = arrayList.get(i);
        }
        return array;
    }

    Integer[] sort(Integer[] array) {
        this.insertArray(array);
        ArrayList<Integer> arrayList = new ArrayList();
        arrayList = this.sortedArray(this.root, arrayList);
        Integer[] arrayReturn = new Integer[arrayList.size()];
        arrayReturn = this.listArrayConverter(arrayList);
        return arrayReturn;
    }

}
