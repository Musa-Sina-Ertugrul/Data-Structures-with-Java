/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.graph;

/**
 *
 * @author musasina
 */
public class Stackll<AnyType> {

    Node<AnyType> top;
    Node<AnyType> bottom;
    int count;

    public Stackll() {
        this.top = null;
        this.count = 0;
        this.bottom = null;
    }

    void push(Node node) {
        if (this.count == 0 || this.top == null) {
            this.top = node;
            this.bottom = node;
        } else {
            node.next = top;
            top = node;
        }
        count++;
    }

    Node pop() {
        Node tmp;
        if (this.count == 0 || this.top == null) {
            return null;
        } else if (this.bottom == this.top) {
            tmp = this.bottom;
            this.bottom = null;
            this.top = null;
            count = 0;
            return tmp;
        } else {
            tmp = top;
            top = top.next;
            count--;
            return tmp;
        }
    }

    Node peek() {
        if (this.count == 0 || this.top == null) {
            return null;
        } else {
            return top;
        }
    }

    boolean isEmpty() {
        return this.top == null;
    }

    boolean search(int value) {
        Node<Integer> tmp = (Node<Integer>) this.bottom;
        while (tmp != null) {
            if (tmp.data == value) {
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

}
