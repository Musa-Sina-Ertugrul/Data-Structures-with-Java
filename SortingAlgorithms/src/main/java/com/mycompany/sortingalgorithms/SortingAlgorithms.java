/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.sortingalgorithms;

/**
 *
 * @author musasina
 */
public class SortingAlgorithms {

    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            int tmp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = tmp;
        }
        return array;
    }

    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
        return array;
    }

    public static int[] insertionSort(int[] array) {
        int insert;
        int moveItem;

        for (int next = 1; next < array.length; next++) {
            insert = array[next];
            moveItem = next;
            while (moveItem > 0 && insert < array[moveItem - 1]) {
                array[moveItem] = array[moveItem - 1];
                moveItem--;
            }
            array[moveItem] = insert;
        }
        return array;
    }

    public static int[] shellSort(int[] array) {
        int insert;
        int moveItem;

        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int next = gap; next < array.length; next++) {
                insert = array[next];
                moveItem = next;
                while (moveItem >= gap && insert < array[moveItem - gap]) {
                    array[moveItem] = array[moveItem - gap];
                    moveItem -= gap;
                }
                array[moveItem] = insert;
            }
        }
        return array;
    }

    public static int[] mergeSort(int[] array) {
        merge(array, 0, array.length);
        return array;
    }

    public static void merge(int[] array, int start, int end) {
        if (start == end) {
            return;
        }
        int center = (start + end) / 2;
        merge(array, 0, center);
        merge(array, center + 1, end);
        sort(array, 0, center);
        sort(array, center + 1, end);
    }

    public static void sort(int[] array, int start, int end) {
        int insert;
        int moveItem;

        for (int next = start + 1; next < end; next++) {
            insert = array[next];
            moveItem = next;
            while (moveItem > 0 && insert < array[moveItem - 1]) {
                array[moveItem] = array[moveItem - 1];
                moveItem--;
            }
            array[moveItem] = insert;
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        int[] array = {9, 2, 5, 10, 1, 4, 6, 3, 8, 7};
        //printArray(selectionSort(array));
        //printArray(bubbleSort(array));
        //printArray(insertionSort(array));
        //printArray(shellSort(array));
        printArray(mergeSort(array));
    }
}
