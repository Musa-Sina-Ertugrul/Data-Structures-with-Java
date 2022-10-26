/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hashtable;

/**
 *
 * @author musasina
 */
public class HashTable<AnyType> {

    Object[][] array;
    int hashNum;

    public HashTable(int hashNum) {
        this.hashNum = hashNum;
        array = (Integer[][]) new Object[hashNum][hashNum];
    }

    void insert(int data) {
        int remiender = data % this.hashNum;
        if (this.array[remiender][remiender] == null) {
            this.array[remiender][remiender] = data;
        } else {
            int remiender2 = (data + (this.hashNum / 2)) % this.hashNum;
            if (this.array[remiender][remiender2] == null) {
                this.array[remiender][remiender2] = data;
            } else {
                System.out.println("Places are full");
            }
        }
    }

    Integer getData(int index) {
        if (this.array[index][index] != null) {
            return (Integer)this.array[index][index];
        }else{
            int index2 = (index+(this.hashNum/2))%this.hashNum;
            if(this.array[index][index2] != null){
                return (Integer) this.array[index][index2];
            }else{
                return null;
            }
        }
    }
    
    void deleteData(int data){
        int index = data % this.hashNum;
        if(this.array[index][index]== null){
            int index2 = (data+(this.hashNum/2))%this.hashNum;
            if(this.array[index][index2]==null){
                System.out.println("There is no such data like that");
            }else{
                this.array[index][index2] = null;
            }
        }else{
            this.array[index][index]=null;
        }
    }
    
    void printTable(){
        for(int i = 0;i< this.array.length;i++){
            for(int j = 0;j < this.array.length;j++){
                System.out.print(this.array[i][j]);
            }
            System.out.println();
        }
    }
}
