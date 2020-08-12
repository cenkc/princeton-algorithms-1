package com.cenkc.courses.princetonalgorithms1.amazon;

/**
 * https://www.devglan.com/datastructure/dijkstra-algorithm-java
 *
 * created by cenkc on 8/5/2020
 */
public class Dijkstra {

    public static void dijkstra(int[][] graph, int sourceVertex) {

        int vertexCount = graph.length;
        boolean[] visitedVertex = new boolean[vertexCount];
        int[] distance = new int[vertexCount];

        for (int i = 0; i < vertexCount; i++) {
            visitedVertex[i] = false;
            distance[i] = Integer.MAX_VALUE;
        }

        distance[sourceVertex] = 0; // distance of sourceVertex to itself is zero

        for (int i = 0; i < vertexCount; i++) {
            int u = findMinDistance(distance, visitedVertex);
            visitedVertex[u] = true;
            for (int v = 0; v < vertexCount; v++) {
                if ( ! visitedVertex[v] &&
                        graph[u][v] != 0 &&
                        (distance[u] + graph[u][v] < distance[v])
                ) {
                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }

        for (int i = 0; i < distance.length; i++) {
            System.out.println(String.format("Distance from source vertex %s to vertex %s is %s", sourceVertex, i, distance[i]));
        }
    }

    private static int findMinDistance(int[] distance, boolean[] visitedVertex) {
        int minDistance = Integer.MAX_VALUE;
        int minDistanceVertex = -1;

        for (int i = 0; i < distance.length; i++) {
            if ( ! visitedVertex[i] && distance[i] < minDistance) {
                minDistance = distance[i];
                minDistanceVertex = i;
            }
        }
        return minDistanceVertex;
    }

    public static void main(String[] args) {
//        int graph[][] = new int[][] {
//                { 0, 4, 8, 0, 0 },
//                { 4, 0, 2, 5, 0 },
//                { 8, 2, 0, 5, 9},
//                { 0, 5, 5, 0, 4 },
//                { 0, 0, 9, 4, 0 }
//        };

        int graph[][] = new int[][] {
                {0, 100, 500},
                {0,   0, 100},
                {0,   0,   0}
        };

        Dijkstra t = new Dijkstra();
        t.dijkstra(graph, 0);
    }
}
