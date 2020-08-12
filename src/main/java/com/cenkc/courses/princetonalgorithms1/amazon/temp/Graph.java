package com.cenkc.courses.princetonalgorithms1.amazon.temp;

import java.util.*;

/**
 * https://stackabuse.com/graphs-in-java-representing-graphs-in-code/
 *
 * created by cenkc on 8/2/2020
 */
public class Graph {

    static class Node {
        int n;
        String name;
        public Node(int n, String name) {
            this.n = n;
            this.name = name;
        }
    }

    private Map<Node, LinkedList<Node>> adjacencyMap;
    private boolean directed;

    public Graph(boolean directed) {
        this.directed = directed;
        this.adjacencyMap = new HashMap<>();
    }

    public void bfs(Node node) {
        if (node == null) {
            return;
        }

        List<Node> visited = new ArrayList<>();
        LinkedList<Node> q = new LinkedList<>();
        q.add(node);

        while ( ! q.isEmpty()) {
            final Node pick = q.removeFirst();
            if (visited.contains(pick)) {
                continue;
            }
            visited.add(pick);
            System.out.print(pick.name + " ");
            final LinkedList<Node> neighbors = adjacencyMap.get(pick);
            if (neighbors == null) {
                continue;
            }
            for (Node n : neighbors) {
                if ( ! visited.contains(n)) {
                    q.add(n);
                }
            }
        }
        System.out.println();
    }

    public void addEdge(Node src, Node dst) {
        add(src, dst);
        if (!directed) {
            add(dst, src);
        }
    }

    private void add(Node a, Node b) {
        if (adjacencyMap.containsKey(a)) {
            LinkedList<Node> aNodes = adjacencyMap.get(a);
            if ( ! aNodes.contains(b)) {
                aNodes.add(b);
            }
        } else {
            LinkedList<Node> aNodes = new LinkedList<>();
            aNodes.add(b);
            adjacencyMap.put(a, aNodes);
        }
    }

    public boolean hasEdge(Node src, Node dst) {
        if (adjacencyMap.containsKey(src)) {
            if (adjacencyMap.get(src).contains(dst)) {
                return true;
            }
        }
        return false;
    }

    public void printEdges() {
        final Set<Map.Entry<Node, LinkedList<Node>>> entries = adjacencyMap.entrySet();
        for (Map.Entry<Node, LinkedList<Node>> entry : entries) {
            StringBuffer sb = new StringBuffer();
            sb.append(entry.getKey().name).append(" to : ");
            for (Node node : entry.getValue()) {
                sb.append(node.name + " ");
            }
            System.out.println(sb.toString().trim());
        }
    }

    public static void main(String[] args) {
//        2 0 3 1

        Graph graph = new Graph(false);
        Node a = new Node(0, "0");
        Node b = new Node(1, "1");
        Node c = new Node(2, "2");
        Node d = new Node(3, "3");

        graph.addEdge(a, b);
        graph.addEdge(a, c);

        graph.addEdge(b, c);
        graph.addEdge(c, a);

        graph.addEdge(c, d);
        graph.addEdge(d, d);

        graph.printEdges();
        System.out.println("------------");
        graph.bfs(c);


//        Graph graph = new Graph(true);
//        Node a = new Node(0, "A");
//        Node b = new Node(1, "B");
//        Node c = new Node(2, "C");
//        Node d = new Node(3, "D");
//        Node e = new Node(4, "E");
//
//        graph.addEdge(a,b);
//        graph.addEdge(b,c);
//        graph.addEdge(b,d);
//        graph.addEdge(c,e);
//        graph.addEdge(b,a);
//
//        graph.printEdges();
//
//        System.out.println(graph.hasEdge(a,b));
//        System.out.println(graph.hasEdge(d,a));
//
//
//        graph.bfs(b);
    }
}
