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
                    arrayWay[index] -= this.cycleHelper(tmp.data, count, queue, array, startCount) + 1;
                    index++;
                    array[count] = 0;
                } else {
                    arrayWay[index] = 10;
                    index++;
                }
                tmp = tmp.next;
            }
        }
        return this.smallestFinder(arrayWay);
    }

    MultiReturn cycleSecond(int node, int startNode, int count, int[] array, MultiReturn multi, int backInt) {
        int[] arrayWay = new int[this.array[node].nodeCount()];
        if ((node != startNode || (node == startNode && count == 0)) && node != backInt) {
            if (!this.valueChecker(node, array)) {
                array[count] = node;
                count++;
            }
            int index = 0;
            int[] arrayTmp = array.clone();
            Node<Integer> tmp = this.array[node].first;
            while (index != arrayWay.length) {
                arrayTmp = array.clone();
                if (!this.valueChecker(tmp.data, arrayTmp)) {
                    arrayWay[index] -= count;
                } else {
                    arrayWay[index] = 100;
                }
                index++;
                tmp = tmp.next;
            }
            tmp = this.array[node].first;
            int smallest = this.smallestFinder(arrayWay);
            if (this.isThereSame(smallest, arrayWay)) {
                int[] arraySame = this.sameIndexesSmall(arrayWay);
                int[] arrayVS = new int[arraySame.length];
                for (int i = 0; i < arrayVS.length; i++) {
                    int tmpIndex = arraySame[i];
                    while (tmpIndex > 1) {
                        tmp = tmp.next;
                        tmpIndex -= 1;
                    }
                    arrayTmp = array.clone();
                    arrayVS[i] = this.cycleSecondHelper(arrayTmp, 0, tmp.data, startNode);
                    tmp = this.array[node].first;
                }
                index = arraySame[this.smallestIndexFinder(arrayVS)];
            } else {
                index = this.smallestIndexFinder(arrayWay);
            }
            tmp = this.array[node].first;
            if (arrayWay[index] == 100) {
                if (this.array[node].search(startNode) != null) {
                    multi.stack.push(new Node<Integer>(node));
                    return multi;
                } else {
                    this.cycleSecond(backInt, startNode, count, array, multi, backInt);
                }
            } else {
                tmp = this.array[node].first;
                while (index > 0) {
                    index -= 1;
                    tmp = tmp.next;
                }
                if (!multi.stack.search(node)) {
                    multi.stack.push(new Node<Integer>(node));
                }
                this.cycleSecond(tmp.data, startNode, count, array, multi, node);
            }
        }
        return multi;
    }

    int cycleSecondHelper(int[] array, int count, int node, int startNode) {
        int result = 10;
        if (!this.valueChecker(node, array)) {
            array[count] = node;
            count++;
            int index = 0;
            int[] arrayWay = new int[this.array[node].nodeCount()];
            Node<Integer> tmp = this.array[node].first;
            while (index != this.array[node].nodeCount()) {
                if (!this.valueChecker(tmp.data, array)) {
                    int[] arrayTmp = array.clone();
                    arrayWay[index] -= this.cycleSecondHelper(arrayTmp, count, tmp.data, startNode);
                } else {
                    arrayWay[index] = 100;
                }
                index++;
                tmp = tmp.next;
            }
            int smallest = this.smallestFinder(arrayWay);
            if (smallest == 100) {
                if (this.array[node].search(startNode) != null) {
                    return 20;
                }
                return 1;
            } else {
                result = this.smallestFinder(arrayWay);
            }
        }
        return result;
    }

    MultiReturn hamiltonPath(int node, int startNode, int count, int[] array, MultiReturn multi, int backInt) {
        int[] arrayWay = new int[this.array[node].nodeCount()];;
        if ((node != startNode || (node == startNode && count == 0)) && node != backInt) {
            if (!this.valueChecker(node, array)) {
                array[count] = node;
                count++;
            }
            multi.num = count;
            int index = 0;
            int[] arrayTmp = array.clone();
            Node<Integer> tmp = this.array[node].first;
            while (index != arrayWay.length) {
                arrayTmp = array.clone();
                if (!this.valueChecker(tmp.data, arrayTmp)) {
                    arrayWay[index] += 5;
                } else {
                    arrayWay[index] = 1;
                }
                index++;
                tmp = tmp.next;
            }
            tmp = this.array[node].first;
            int biggest = this.biggestFinder(arrayWay);
            if (this.isThereSame(biggest, arrayWay)) {
                int[] arraySame = this.sameIndexesBig(arrayWay);
                int[] arrayVS = new int[arraySame.length];
                for (int i = 0; i < arrayVS.length; i++) {
                    int tmpIndex = arraySame[i];
                    while (tmpIndex > 0) {
                        tmp = tmp.next;
                        tmpIndex -= 1;
                    }
                    arrayTmp = array.clone();
                    arrayVS[i] = this.hamiltonPathHelper(arrayTmp, 0, tmp.data, startNode);
                    tmp = this.array[node].first;
                }
                index = arraySame[this.biggestIndexFinder(arrayVS)];
            } else {
                index = this.biggestIndexFinder(arrayWay);
            }
            tmp = this.array[node].first;
            if (arrayWay[index] == 1) {
                if (this.array[node].search(startNode) != null) {
                    multi.stack.push(new Node<Integer>(node));
                    return multi;
                } else {
                    this.hamiltonPath(backInt, startNode, count, array, multi, backInt);
                }
            } else {
                tmp = this.array[node].first;
                while (index > 0) {
                    index -= 1;
                    tmp = tmp.next;
                }
                if (!multi.stack.search(node)) {
                    multi.stack.push(new Node<Integer>(node));
                }
                this.hamiltonPath(tmp.data, startNode, count, array, multi, node);
            }
        }
        return multi;
    }

    int hamiltonPathHelper(int[] array, int count, int node, int startNode) {
        int result = 1;
        if (!this.valueChecker(node, array)) {
            array[count] = node;
            count++;
            int index = 0;
            int[] arrayWay = new int[this.array[node].nodeCount()];
            Node<Integer> tmp = this.array[node].first;
            while (index != this.array[node].nodeCount()) {
                if (!this.valueChecker(tmp.data, array)) {
                    int[] arrayTmp = array.clone();
                    arrayWay[index] += this.hamiltonPathHelper(arrayTmp, count, tmp.data, startNode);
                } else {
                    arrayWay[index] = 1;
                }
                index++;
                tmp = tmp.next;
            }
            int biggest = this.biggestFinder(arrayWay);
            if (biggest == 1) {
                if (this.array[node].search(startNode) != null && count == this.array.length - 1) {
                    return 20;
                }
                return 5;
            } else {
                result = biggest;
            }
        }
        return result;
    }

    int biggestFinder(int[] array) {
        int num = array[0];
        for (int i = 0; i < array.length; i++) {
            if (num < array[i]) {
                num = array[i];
            }
        }
        return num;
    }

    Integer biggestFinder(int[] array, int[] values) {
        int num = array[0];
        for (int i = 0; i < array.length; i++) {
            if (!this.valueChecker(num, array)) {
                if (num < array[i]) {
                    num = array[i];
                }
            }
        }
        if (this.valueChecker(num, array)) {
            return null;
        }
        return num;
    }

    int biggestIndexFinder(int[] array) {
        int num = array[0];
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            if (num < array[i]) {
                index = i;
                num = array[i];
            }
        }
        return index;
    }

    int smallestIndexFinder(int[] array) {
        int num = array[0];
        int index = 0;
        for (int i = 1; i < array.length; i++) {
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

    int[] sameIndexesSmall(int[] array) {
        int num = this.smallestFinder(array);
        int length = 0;
        for (int i = 0; i < array.length; i++) {
            if (num == array[i]) {
                length++;
            }
        }
        int index = 0;
        int[] arrayReturn = new int[length];
        for (int i = 0; i < array.length; i++) {
            if (num == array[i]) {
                arrayReturn[index] = i;
                index++;
            }
        }
        return arrayReturn;
    }

    int[] sameIndexesBig(int[] array) {
        int num = this.biggestFinder(array);
        int length = 0;
        for (int i = 0; i < array.length; i++) {
            if (num == array[i]) {
                length++;
            }
        }
        int index = 0;
        int[] arrayReturn = new int[length];
        for (int i = 0; i < array.length; i++) {
            if (num == array[i]) {
                arrayReturn[index] = i;
                index++;
            }
        }
        return arrayReturn;
    }

    boolean isThereSame(int value, int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (value == array[i]) {
                count++;
            }
        }
        if (count > 1) {
            return true;
        }
        return false;
    }

    MultiReturn topologicalSort(int[] array, MultiReturn multi, String type) {
        // sorting konusuna gelince doldurulacak
        // ipucu: bfs veya dfs le node ları al array e at sonra bi tane sorting algoritması ile sırala
        return multi;
    }
}
