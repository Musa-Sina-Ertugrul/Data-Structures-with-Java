/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.queue;

/**
 *
 * @author musasina
 */
public class Main {
    public static void main(String[] args) {
        Element e1 = new Element(50);
        Element e2 = new Element(50);
        Element e3 = new Element(50);
        Element e4 = new Element(50);
        Element e5 = new Element(50);
        
        Element[] array = {e1,e2,e3,e4,e5};
        int[] points = {50,50,50,50,50};
        Queue q1 = new Queue(5);
        Queue q2 = new Queue(5);
        q2.enqueue(e1);
        q2.enqueue(e2);
        System.out.println(Queue.dartGame(points, q1));
    }
}
