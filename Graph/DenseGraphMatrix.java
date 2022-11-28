/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.graph;

/**
 *
 * @author musasina
 */
public class DenseGraphMatrix {

    int[][] array;

    public DenseGraphMatrix(int vertices) {
        array = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (i == j) {
                    array[i][j] = 0;
                } else {
                    array[i][j] = 1;
                }
            }
        }
    }

    boolean bfsStrSearch(String text, char num) {
        char[] array = text.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                return true;
            }
        }
        return false;
    }

    boolean bfsArraySearch(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    String bfs(int node) {
        int[] array = new int[this.array.length];
        array[0]= node;
        for (int i = 1; i < this.array.length; i++) {
            for (int j = 0; j < this.array.length; j++) {
                if (this.array[node][j] == 0) {
                    continue;
                } else {
                    if (!this.bfsArraySearch(array, j)) {
                        array[i] = j;
                        node = j;
                        break;
                    }
                    
                }
            }
        }
        String result = "";
        for (int i = 0; i < array.length; i++) {
            result += String.valueOf(array[i]+1);
        }
        return result;
    }
    
    String dfs(int node){
        return "";
    }

    void deletion(int num1, int num2) {
        array[num1][num2] = 0;
        array[num2][num1] = 0;
    }
}
