/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hashtable;

/**
 *
 * @author musasina
 */
public class HashTablell <AnyType> {
    Linked_list<AnyType>[] array;
    public HashTablell(int size){
        array = new Linked_list[size];
    }
    
    void insert(int data){
        int index = data/(this.array.length);
        if(this.array[index]== null){
            this.array[index] = new Linked_list();
            this.array[index].insertFirst(new Node(data));
        }else{
            this.array[index].insertLast(new Node(data));
        }
    }
    
    Integer search(int data){
        int index = data/(this.array.length);
        if(this.array[index]== null){
            return null;
        }else{
            Node tmp = this.array[index].first;
            while(tmp != null && Integer.parseInt(tmp.data.toString()) != data){
                tmp = tmp.next;
            }
            if(tmp == null){
                return null;
            }else{
                return data;
            }
        }
    }
    
    void delete(int data){
        int index = data/(this.array.length);
        if(this.array[index] != null){
            Node prev = null;
            Node tmp = this.array[index].first;
            while(tmp != null && Integer.parseInt(tmp.data.toString()) != data){
                prev = tmp;
                tmp = tmp.next;
            }
            prev.next = tmp.next;
        }
        
    }
    
    void printTable(){
        for(int i = 0; i<this.array.length;i++){
            Node tmp = this.array[i].first;
            while(tmp != null){
                System.out.println(tmp.data.toString());
                tmp = tmp.next;
            }
        }
    }
}
