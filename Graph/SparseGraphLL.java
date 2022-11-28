/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.graph;

/**
 *
 * @author musasina
 */
public class SparseGraphLL {

    Linked_list[] array;

    public SparseGraphLL(int vertices) {
        array = new Linked_list[vertices];
        for (int i = 0; i < vertices; i++) {
            array[i] = new Linked_list<Integer>();
        }
    }

    void insterEdgeBoth(int vertex1, int vertex2) {
        int count1 = 0;
        int count2 = 0;
        Node tmp = array[vertex1 - 1].first;
        while (tmp != null) {
            count1++;
            if (Integer.parseInt(tmp.data.toString()) != vertex2) {
                count2++;
            }
            tmp = tmp.next;
        }
        if (count1 == count2) {
            array[vertex1 - 1].insertLast(new Node<Integer>(vertex2 - 1));
            array[vertex2 - 1].insertLast(new Node<Integer>(vertex1 - 1));
        }

    }

    void deleteEdgeBoth(int vertex1, int vertex2) {
        Node<Integer> tmp = array[vertex1 - 1].first;
        Node prev_tmp = null;
        if (tmp != null) {
            while (tmp.data != vertex2 && tmp != null) {
                prev_tmp = tmp;
                tmp = tmp.next;
            }
            if (tmp == null) {
                return;
            } else {
                if (prev_tmp == null) {
                    array[vertex1 - 1].first = null;
                    array[vertex1 - 1].last = null;
                } else if (prev_tmp != null && tmp.next == null) {
                    prev_tmp.next = null;
                } else {
                    prev_tmp.next = tmp.next;
                }

            }
        }
        tmp = array[vertex2 - 1].first;
        prev_tmp = null;
        if (tmp != null) {
            while (tmp.data != vertex1 && tmp != null) {
                prev_tmp = tmp;
                tmp = tmp.next;
            }
            if (tmp == null) {
                return;
            } else {
                if (prev_tmp == null) {
                    array[vertex2 - 1].first = null;
                    array[vertex2 - 1].last = null;
                } else if (prev_tmp != null && tmp.next == null) {
                    prev_tmp.next = null;
                } else {
                    prev_tmp.next = tmp.next;
                }

            }
        }
    }

    void insertEdge(int vertex1, int vertex2) {
        int count1 = 0;
        int count2 = 0;
        Node tmp = array[vertex1 - 1].first;
        while (tmp != null) {
            count1++;
            if (Integer.parseInt(tmp.data.toString()) != vertex2) {
                count2++;
            }
            tmp = tmp.next;
        }
        if (count1 == count2) {
            array[vertex1 - 1].insertLast(new Node<Integer>(vertex2 - 1));
        }
    }

    void deleteEdge(int vertex1, int vertex2) {
        Node<Integer> tmp = array[vertex1 - 1].first;
        Node prev_tmp = null;
        if (tmp != null) {
            while (tmp.data != vertex2 && tmp != null) {
                prev_tmp = tmp;
                tmp = tmp.next;
            }
            if (tmp == null) {
                return;
            } else {
                if (prev_tmp == null) {
                    array[vertex1 - 1].first = null;
                    array[vertex1 - 1].last = null;
                } else if (prev_tmp != null && tmp.next == null) {
                    prev_tmp.next = null;
                } else {
                    prev_tmp.next = tmp.next;
                }

            }
        }
    }

    Queuell bfs(int node, Queuell<Integer> queue, int count) {
        if (!queue.search(node) && count != this.array.length) {
            queue.enqueue(new Node<Integer>(node));
            count++;
            Node<Integer> tmp = this.array[node].first;
            while (tmp != null) {
                this.bfs(tmp.data, queue, count);
                tmp = tmp.next;
            }
        }
        return queue;
    }

    Stackll<Integer> dfs(int node, Stackll<Integer> stack, int count) {
        if (!stack.search(node) && count != this.array.length) {
            stack.push(new Node<Integer>(node));
            count++;
            Node<Integer> tmp = this.array[node].first;
            while (tmp != null) {
                this.dfs(tmp.data, stack, count);
                tmp = tmp.next;
            }
        }
        return stack;
    }

    Queuell cycle(int node, Queuell<Integer> queue, int count, int backInt) {
        if ((!queue.search(node)) && (node != backInt)) {
            queue.enqueue(new Node<Integer>(node));
            count++;
            Node<Integer> tmp = (Node<Integer>) this.array[node].first;
            if (this.array[node].nodeCount() > 2) {
                int[] array = new int[this.array[node].nodeCount()];
                int[] arrayHelper = new int[this.array.length];
                int index = 0;
                while (tmp != null) {
                    if (!queue.search(tmp.data)) {
                        int num = this.cycleHelper(tmp.data, 0, queue, arrayHelper, count);
                        array[index] = num;
                        index++;
                        tmp = tmp.next;
                    } else {
                        array[index] = 100;
                        index++;
                        tmp = tmp.next;
                    }
                }
                index = this.smallestIndexFinder(array) + 1;
                tmp = (Node<Integer>) this.array[node].first;
                while (index > 1 || !queue.search(node)) {
                    tmp = tmp.next;
                    index -= 1;
                }
                this.cycle(tmp.data, queue, count, backInt);
            } else {
                if (!queue.search(tmp.data)) {
                    this.cycle(tmp.data, queue, count, backInt);
                } else {
                    tmp = tmp.next;
                    if (tmp == null) {
                        tmp = (Node<Integer>) this.array[node].first;
                        if (this.array[tmp.data].isThere(queue) == this.array[tmp.data].nodeCount()) {
                            return queue;
                        } else {
                            queue.enqueue(tmp);
                            backInt = node;
                        }
                        this.cycle(tmp.data, queue, count, backInt);
                    } else {
                        this.cycle(tmp.data, queue, count, backInt);
                    }
                }
            }

        }
        return queue;
    }

    int cycleHelper(int node, int count, Queuell<Integer> queue, int[] array, int startCount) {
        int[] arrayWay = new int[this.array[node].nodeCount()];
        if (!queue.search(node) && !this.valueChecker(node, array)) {
            array[count] = node;
            count++;
            int index = 0;
            Node<Integer> tmp = this.array[node].first;
            while (index != arrayWay.length) {
                if (!queue.search(tmp.data) && !this.valueChecker(tmp.data, array)) {
                    arrayWay[index] -= this.cycleHelper(tmp.data, count, queue, array, startCount)+1;
                    index++;
                    array[count]=0;
                } else {
                    arrayWay[index] = 10;
                    index++;
                }
                tmp = tmp.next;
            }
        }
        return this.smallestFinder(arrayWay);
    }

    int smallestIndexFinder(int[] array) {
        int num = array[0];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (num > array[i]) {
                num = array[i];
                index = i;
            }
        }
        return index;
    }

    int smallestFinder(int[] array) {
        int num = array[0];
        for (int i = 0; i < array.length; i++) {
            if (num > array[i]) {
                num = array[i];
            }
        }
        return num;
    }

    boolean valueChecker(int value, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

}
