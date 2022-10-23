/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.stack;

/**
 *
 * @author musasina
 */
public class Stack<T, U> {

    Element[] array;
    int top;
    int N;

    public Stack(int N) {
        this.N = N;
        this.top = -1;
        array = new Element[N];
    }

    Element<T> peek() {
        return array[top];
    }

    boolean isFull() {
        if (top == N - 1) {
            return true;
        }
        return false;
    }

    boolean isEmpty() {
        if (top == -1) {
            return true;
        }
        return false;
    }

    void push(Element<U> element) {
        if (!this.isFull()) {
            top++;
            array[top] = element;
        }
    }

    Element<T> pop() {
        if (!this.isEmpty()) {
            Element<T> result = array[top];
            top--;
            return result;
        }
        return null;
    }

    static String infixPostfix(String str) {

        Stack stc = new Stack(str.length()/2);
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char chr = str.charAt(i);

            if (Stack.degree(chr) > 0) {
                while (!stc.isEmpty() && Stack.degree(stc.peek().data.toString().charAt(0)) >= Stack.degree(chr)) {
                    result += stc.pop().data.toString();
                }
                stc.push(new Element(chr));
            } else if (chr == '(') {
                result += Stack.infixPostfix(str.substring(++i, str.lastIndexOf(")")-2));

            } else if(chr == ')'){
                continue;
            }else {
                result += chr;
            }
        }
        while(!stc.isEmpty()){
            result += stc.pop().data.toString();
        }
        return result;
    }
    
    static int calculate(String str){
        String postfix = Stack.infixPostfix(str);
        int result = 0;
        
        Stack stc = new Stack(postfix.length());
        
        for(int i = 0; i< postfix.length();i++){
            char chr = postfix.charAt(i);
            while(!Stack.isOperator(chr)){
                stc.push(new Element(chr));
                i++;
                chr = postfix.charAt(i);
            }
            if(chr == '*' || chr == '/' || chr == '-' || chr == '+'){
                int num_2 = Integer.parseInt(stc.pop().data.toString());
                int num_1 = Integer.parseInt(stc.pop().data.toString());
                if(chr == '*')
                    num_1 = num_1*num_2;
                else if(chr == '/')
                    num_1 = num_1/num_2;
                else if(chr == '+')
                    num_1 += num_2;
                else if(chr == '-')
                    num_1 -= num_2;
                stc.push(new Element(num_1));
            }
        }
        result = Integer.parseInt(stc.pop().data.toString());
        return result;
    }

    static int degree(char chr) {
        switch (chr) {
            case '+':

            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }
    static boolean isOperator(char chr){
        
        switch(chr){
            case '*':
                return true;
            case '/':
                return true;
            case '+':
                return true;
            case '-':
                return true;
            
        }
        
        return false;
    }
    
    void printStack(){
        Element[] array = new Element[this.top+1];
        int index = 0;
        while(!this.isEmpty()){
            array[index]= this.pop();
            System.out.println(array[index].toString());
            index++;
        }
        for(int i = array.length-1;i>=0;i--){
            this.push(array[i]);
        }
    }
}
