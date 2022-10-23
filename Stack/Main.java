/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.stack;

/**
 *
 * @author musasina
 */
public class Main {
    
    public static void main(String[] args) {
        String raw_text = "4+5*3+(2/1)";
        System.out.println(Stack.infixPostfix(raw_text));
        System.out.println(Stack.calculate(raw_text));
    }
}
