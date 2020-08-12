package com.cenkc.courses.princetonalgorithms1.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.softwaretestinghelp.com/java-graph-tutorial/
 *
 * created by cenkc on 8/5/2020
 */
public class Graph {
    class Edge {
        int src, dst, weight;
        public Edge(int src, int dst, int weight) {
            this.src = src;
            this.dst = dst;
            this.weight = weight;
        }
    }
    class Node {
        int value, weight;
        public Node(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    List<List<Node>> adjacencyList = new ArrayList<>();

    public Graph(List<Edge> edges) {

        for (int i = 0; i < edges.size(); i++) {
            adjacencyList.add(i, new ArrayList<>());
        }

//        for (Edge edge : edges) {
//            adjacencyList.get()
//        }

    }
}
