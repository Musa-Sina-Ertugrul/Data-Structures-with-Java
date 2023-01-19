/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.heap;

/**
 *
 * @author musasina
 */
public class Heap {
    int[] heap;
    int size;
    Heap(int maxSize){
        heap = new int[maxSize];
        size = -1;
    }
    
    int parent(int i){
        return (i-1)/2;
    }
    
    int leftChild(int i){
        return 2*i + 1;
    }
    
    int rightChild(int i){
        return 2*i +2;
    }
    
    void insert(int data){
        if(this.size == this.heap.length -1)
            System.out.println("heap is full");
        else{
            this.size++;
            this.heap[this.size] = data;
            
            int currentIndex = this.size;
            
            while(currentIndex != 0){
                if(this.heap[this.parent(currentIndex)]>this.heap[currentIndex]){
                    int tmp = this.heap[currentIndex];
                    this.heap[currentIndex]= this.heap[this.parent(currentIndex)];
                    this.heap[this.parent(currentIndex)] = tmp;
                    currentIndex = this.parent(currentIndex);
                }else{
                    currentIndex = 0;
                }
            }
        }
    }
    
    int extractMin(){
        int result =this.heap[0];
        this.heap[0] = this.heap[this.size];
        this.heap[this.size] = 0;
        int currentIndex = 0;
        while(currentIndex<this.heap.length-1){
            int right = this.heap[this.rightChild(currentIndex)];
            int left = this.heap[this.leftChild(currentIndex)];
            if(right < this.heap[currentIndex]){
                int tmp = this.heap[currentIndex];
                this.heap[currentIndex] = right;
                this.heap[this.rightChild(currentIndex)] = tmp;
            }else if (left < this.heap[currentIndex]){
                int tmp = this.heap[currentIndex];
                this.heap[currentIndex] = left;
                this.heap[this.leftChild(currentIndex)] = tmp;
            }else{
                break;
            }
        }
        return result;
    }
    
    void printList(){
        for(int i = 0;i<this.heap.length;i++){
            System.out.println(this.heap[i]);
        }
    }
}
