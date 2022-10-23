/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.queue;

import java.util.Random;

/**
 *
 * @author musasina
 */
public class Queue<AnyType> {

    Element<AnyType>[] array;
    int last;

    public Queue(int len) {
        array = new Element[len];
        last = -1;
    }

    boolean isEmpty() {
        return (last == -1);
    }

    boolean isFull() {
        return last == array.length - 1;
    }

    void enqueue(Element<AnyType> data) {
        if (!this.isFull()) {
            this.last++;
            this.array[this.last] = data;
        }
    }

    Element<AnyType> dequeue() {
        if (!this.isEmpty()) {
            Element<AnyType> tmp = this.array[0];
            for (int i = 0; i < this.last; i++) {
                this.array[i] = this.array[i + 1];
            }
            this.array[this.last--] = null;
            return tmp;
        }
        return null;
    }

    static <AnyType> boolean isBig(Queue<AnyType> darts) {
        int total = 0;
        int[] data = new int[darts.last + 1];
        int index = 0;
        while (!darts.isEmpty()) {
            data[index] = Integer.parseInt(darts.dequeue().data.toString());
            total += data[index];
            index++;
        }
        for (int i = 0; i < data.length; i++) {
            darts.enqueue(new Element(data[i]));
        }
        return total > 100;
    }

    static <AnyType> boolean isEnough(Queue<AnyType> darts) {
        int total = 0;
        int[] data = new int[darts.last + 1];
        int index = 0;
        while (!darts.isEmpty()) {
            data[index] = Integer.parseInt(darts.dequeue().data.toString());
            total += data[index];
            index++;
        }
        for(int i = 0; i < data.length; i++) {
            darts.enqueue(new Element(data[i]));
        }
        return total == 100;
    }

    static <AnyType> String dartGame(int[] points, Queue<AnyType> darts) {
        Random rand = new Random();
        int rand_int = rand.nextInt(5);
        darts.enqueue(new Element(points[rand_int]));
        if (Queue.isEnough(darts)) {
            String result = "";
            while (!darts.isEmpty()) {

                result += darts.dequeue().data.toString() + " ";
            }
            return result;
        } else if (Queue.isBig(darts)) {
            while (!darts.isEmpty()) {
                darts.dequeue();
            }
            return Queue.dartGame(points, darts);
        } else {
            return Queue.dartGame(points, darts);
        }

    }
    <AnyType> void moveToFront(){
        Element tmp = this.dequeue();
        Element[] tmp_array = (Element[]) new Object[this.last];
        
        for(int i = 0;i<tmp_array.length;i++){
            tmp_array[i]= this.dequeue();
        }
        this.enqueue(tmp);
        for(int i = 0;i<tmp_array.length;i++){
            this.enqueue(tmp_array[i]);
        }
    }
    
    Queue shrinkNth(int num){
        Element[] tmp_array = (Element[]) new Object[num];
        for(int i = 0;i<tmp_array.length;i++){
            tmp_array[i]= this.dequeue();
        }
        Queue tmp_queue = new Queue(num);
        for(int i = 0;i<tmp_array.length;i++){
            tmp_queue.enqueue(tmp_array[i]);
        }
        return tmp_queue;
        
    }
}
