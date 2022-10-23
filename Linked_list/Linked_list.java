/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.linked_list;

import java.util.ArrayList;

/**
 *
 * @author musasina
 */
public class Linked_list<T> {

    Node<T> first;
    Node<T> last;

    public Linked_list() {

        first = null;
        last = null;
    }

    void insertFirst(Node<T> newNode) {
        if (this.last == null) {
            this.last = newNode;

        }
        newNode.next = this.first;
        this.first = newNode;
    }

    void insertLast(Node<T> newNode) {
        if (this.first == null) {
            this.first = newNode;
        } else {
            this.last.next = newNode;
        }
        this.last = newNode;
    }

    void insertMiddle(Node<T> newNode, Node<T> previous) {
        newNode.next = previous.next;
        previous.next = newNode;
    }

    Node<T> search(T value) {
        Node<T> tmp;
        tmp = this.first;
        while (tmp.next != null) {
            if (value == tmp.data) {
                return tmp;
            } else {
                tmp = tmp.next;
            }
        }

        return null;

    }

    Node<T> nodeIth(int i) {
        Node<T> tmp = this.first;
        int j = 0;
        while (j != i && tmp != null) {
            tmp = tmp.next;
            j++;

        }

        return tmp;
    }

    void deleteFirst() {

        if (this.last == null) {
            this.first = null;
        }

        this.first = this.first.next;

    }

    void deleteLast() {
        Node<T> tmp, previous;
        tmp = this.first;
        previous = null;

        while (tmp != this.last) {
            previous = tmp;
            tmp = tmp.next;
        }

        if (this.first == this.last) {
            this.first = null;
            this.last = null;
        } else {
            previous.next = null;
        }
        this.last = previous;
    }

    void deleteMiddle(Node<T> s) {
        Node<T> tmp, previous;
        tmp = this.first;
        previous = tmp;

        while (tmp != s) {
            previous = tmp;
            tmp = tmp.next;
        }

        previous.next = previous.next.next;
    }

    int nodeCount() {
        Node<T> tmp;
        tmp = this.first;
        int count = 0;
        while (tmp != null) {
            count++;
            tmp = tmp.next;
        }

        return count;
    }

    static Linked_list merger(Linked_list l1, Linked_list l2) {
        Linked_list newList = new Linked_list();
        if (l1.first == null) {
            return l2;
        }
        if (l2.first == null) {
            return l1;
        }

        newList.first = l1.first;
        newList.last = l2.first;
        l1.last.next = l2.first;
        return newList;
    }

    int smallest() {
        int tmp_data = (Integer) this.first.data;
        Node<T> tmp = this.first.next;
        while (tmp != null) {
            if (tmp_data > (Integer) tmp.data) {
                tmp_data = (Integer) tmp.data;
            } else {
                tmp = tmp.next;
            }
        }
        return tmp_data;
    }

    void singleRemover() {
        int[] arr_all = new int[this.nodeCount() + 1];
        ArrayList<Integer> arr_second = new ArrayList<>();
        Node tmp = this.first;
        int index = 0;
        while (tmp != null) {
            arr_all[index] = (Integer) tmp.data;
            System.out.println(arr_all[index]);
            tmp = tmp.next;
            index++;
        }
        for (int i = 0; i < arr_all.length - 1; i++) {
            for (int j = i + 1; j < arr_all.length; j++) {
                if (arr_all[i] == arr_all[j]) {
                    arr_second.add(arr_all[i]);

                    break;
                }
            }
        }
        tmp = this.first;
        Node<T> previous = null;
        int count = 0;
        while (tmp != null) {
            for (int i = 0; i < arr_second.size(); i++) {
                int check = (Integer) tmp.data;
                if (check != arr_second.get(i)) {
                    count++;
                }
            }
            if (count == arr_second.size()) {
                previous.next = tmp.next;
            }
            count = 0;
            previous = tmp;
            tmp = tmp.next;
        }

    }

    void removeDup() {
        int[] arr_all = new int[this.nodeCount()];
        ArrayList<Integer> arr_dup = new ArrayList<>();
        Node<T> tmp = this.first;
        Node<T> previous = null;
        int index = 0;
        while (tmp != null) {
            arr_all[index] = (Integer) tmp.data;
            tmp = tmp.next;
            index++;
        }
        for (int i = 0; i < arr_all.length - 1; i++) {
            for (int j = i + 1; j < arr_all.length; j++) {
                if (arr_all[i] == arr_all[j]) {
                    arr_dup.add(arr_all[i]);
                    break;
                }
            }
        }
        tmp = this.first;
        int count = 0;
        while (tmp != null) {

            for (int i = 0; i < arr_dup.size(); i++) {
                int check = (Integer) tmp.data;
                if (check == arr_dup.get(i)) {
                    arr_dup.remove(i);
                    if (previous != null) {
                        previous.next = tmp.next;
                    } else {
                        this.first = tmp.next;
                    }
                }

            }
            System.out.println(tmp.next);
            previous = tmp;
            tmp = tmp.next;
        }

        tmp = this.first;
        while (tmp != null) {
            System.out.println((Integer) tmp.data);
            tmp = tmp.next;
        }
    }

    boolean subList(Linked_list sub) {
        Node<T> tmp_orr = this.first;
        Node<T> tmp_sub = sub.first;
        boolean result = false;
        int count = 0;
        int size = sub.nodeCount();
        while (tmp_orr != null) {
            if (tmp_orr.equals(tmp_sub)) {

                count++;
                tmp_sub = tmp_sub.next;
            } else {
                tmp_sub = sub.first;
                count = 0;

            }
            if (count == size) {
                result = true;
                return result;
            }
            tmp_orr = tmp_orr.next;
        }
        return result;

    }

    Linked_list intersection(Linked_list l) {
        Linked_list result = new Linked_list<>();
        Node<T> tmp_this = this.first;
        Node<T> tmp_l = l.first;
        while (tmp_this != null) {
            System.out.println((Integer) tmp_this.data);
            while (tmp_l != null) {

                if (tmp_this == tmp_l) {
                    result.insertFirst(new Node<>((Integer) tmp_l.data));
                    break;
                }
                tmp_l = tmp_l.next;
            }
            tmp_l = l.first;
            tmp_this = tmp_this.next;
        }

        Node<T> tmp = result.first;
        while (tmp != null) {
            System.out.println((Integer) tmp.data);
            tmp = tmp.next;
        }
        return result;
    }

    public void printList() {
        Node<T> tmp = this.first;
        if (tmp == null) {
            System.out.println("null");
        } else {
            while (tmp != null) {
                System.out.println(tmp.data.toString());
                tmp = tmp.next;
            }
        }
    }
    
    public void deleteNth(int num){
        if(this.nodeCount()<num){
            System.out.println("enter valid number");
        }
        int count = 0;
        Node<T> tmp = this.first;
        Node<T> tmp_p = null;
        while(tmp.next != null && count < num){
            count++;
            tmp = tmp.next;
            tmp_p = tmp.next;
        }
        tmp_p.next = tmp.next;
    }
}
