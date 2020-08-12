package com.cenkc.courses.princetonalgorithms1.amazon;

import java.util.*;

/**
 * created by cenkc on 8/6/2020
 */
public class DijkstraCenk {
    /**
     *
     * @param graph Graph as 2D Array
     * @param src Source Vertex
     */
    public static void dijkstra(int[][] graph, int src) {

        List<List<Integer>> adjList = createAdjList(graph);

        int vtxCount = graph.length; // num.of vertices in the graph
        boolean[] visitedVertices = new boolean[vtxCount]; // array of visited vertices
        int[] distances = new int[vtxCount]; // array of distances

        // initialize
        for (int i = 0; i < vtxCount; i++) {
            visitedVertices[i] = false; // normally don't need to set them explicitly, defaults are already false
            distances[i] = Integer.MAX_VALUE;
        }

        distances[src] = 0; // Distance from source to source is 0, obviously

//        PriorityQueue<Integer> q = new PriorityQueue<>();
//        q.add()


    }

    public static void main(String[] args) {
//        int graph[][] = new int[][] {
//                {0, 100, 500},
//                {0,   0, 100},
//                {0,   0,   0}
//        };
//        List<List<Integer>> adjList = createAdjList(graph);
//        System.out.println(adjList.toString());

        int flights[][] = new int[][] {
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500}
        };

        Map<Integer,List<int[]>> map=new HashMap<>();
        for(int[] f:flights)
        {
            map.putIfAbsent(f[0],new ArrayList<>());
            map.get(f[0]).add(new int[]{f[1],f[2]});
        }


    }

    private static List<List<Integer>> createAdjList(int[][] graph) {
        List<List<Integer>> adjList = new ArrayList<>();

//        for (int i = 0; i < graph.length; i++) {
//            adjList.add(i, new ArrayList<>());
//        }

        for (int i = 0; i < graph.length; i++) {
            adjList.add(i, new ArrayList<>());
            for (int j = 0; j < graph.length; j++) {
                adjList.get(i).add(j, graph[i][j]);
            }
        }

        return adjList;
    }
}
