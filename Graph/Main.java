/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.graph;

/**
 *
 * @author musasina
 */
public class Main {
    public static void main(String[] args) {
        /*DenseGraphMatrix graph = new DenseGraphMatrix(5);
        graph.deletion(0, 1);
        System.out.println(graph.bfs(0));
*/
        SparseGraphLL graph = new SparseGraphLL(5);
        graph.insertEdge(1, 2);
        graph.insertEdge(2, 5);
        graph.insertEdge(2, 3);
        graph.insertEdge(3, 4);
        graph.insertEdge(4, 1);
        graph.insertEdge(5, 3);
        Queuell queue = new Queuell<Integer>();
        queue = graph.bfs(0,queue,0);
        while(!queue.isEmpty()){
            System.out.println(queue.dequeue().data);
        }
        //System.out.println(graph.dfs(0));
        SparseGraphLL graph2 = new SparseGraphLL(5);
        graph2.insterEdgeBoth(1, 2);
        graph2.insterEdgeBoth(2, 5);
        graph2.insterEdgeBoth(2, 3);
        graph2.insterEdgeBoth(3, 4);
        graph2.insterEdgeBoth(4, 1);
        graph2.insterEdgeBoth(5, 3);
        Queuell queue2 = new Queuell<Integer>();
        queue2 = graph2.cycle(0,queue2,0,-1);
        //queue2 = graph2.cycle(0, queue2, 0,0);
        while(!queue2.isEmpty()){
            System.out.println(queue2.dequeue().data);
        }
        //System.out.println("0");
    }
    
    
}
