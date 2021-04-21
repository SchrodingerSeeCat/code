package com.valid;

import com.valid.graph.Graph;
import com.valid.graph.ListGraph;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Graph<String, Integer> graph = new ListGraph<>(new Graph.WeightManager<Integer>() {
            @Override
            public int compare(Integer w1, Integer w2) {
                return w1.compareTo(w2);
            }

            @Override
            public Integer add(Integer w1, Integer w2) {
                return w1 + w2;
            }

            @Override
            public Integer zero() {
                return 0;
            }
        });
//        graph.addEdge("V1", "V0", 9);
//        graph.addEdge("V1", "V2", 3);
//        graph.addEdge("V2", "V0", 2);
//        graph.addEdge("V2", "V3", 5);
//        graph.addEdge("V3", "V4", 1);
//        graph.addEdge("V0", "V4", 6);

//        graph.removeEdge("V0", "V5");
//        graph.removeEdge("V0", "V4");

//        graph.removeVertex("V0");
//        graph.removeVertex("V1");

//        graph.bfs("V1");
//        graph.dfs("V1", value -> {
//            System.out.println(value);
//            return value.equals("V4");
//        });
//        System.out.println(graph.topologicalSort());

//        graph.addUndirectedEdge("A", "B", 17);
//        graph.addUndirectedEdge("A", "F", 1);
//        graph.addUndirectedEdge("A", "E", 16);
//
//        graph.addUndirectedEdge("B", "C", 6);
//        graph.addUndirectedEdge("B", "D", 5);
//        graph.addUndirectedEdge("B", "F", 11);
//
//        graph.addUndirectedEdge("C", "D", 10);
//
//        graph.addUndirectedEdge("F", "E", 33);
//        graph.addUndirectedEdge("F", "D", 14);
//
//        graph.addUndirectedEdge("E", "D", 4);
//
//        System.out.println(graph.mst());

        graph.addEdge("A", "B", 10);
        graph.addEdge("A", "D", 30);
        graph.addEdge("A", "E", 100);

        graph.addEdge("B", "C", 50);
        graph.addEdge("C", "E", 10);
        graph.addEdge("D", "C", 20);
        graph.addEdge("D", "E", 60);

//        graph.addUndirectedEdge("A", "B", 10);
//        graph.addUndirectedEdge("A", "D", 30);
//        graph.addUndirectedEdge("A", "E", 100);
//
//        graph.addUndirectedEdge("B", "C", 50);
//        graph.addUndirectedEdge("C", "E", 10);
//        graph.addUndirectedEdge("D", "C", 20);
//        graph.addUndirectedEdge("D", "E", 60);

        Map<String, Graph.PathInfo<String, Integer>> paths = graph.shortestPath("A");
//        paths.forEach((String key, Graph.PathInfo<String, Integer> value) -> {
//            System.out.println(key + " " + value);
//        });

        Map<String, Map<String, Graph.PathInfo<String, Integer>>> stringMapMap = graph.shortestPath();
        stringMapMap.forEach((String from, Map<String, Graph.PathInfo<String, Integer>> map) -> {
            System.out.println(from + "----------------");
            map.forEach((String to, Graph.PathInfo<String, Integer> path) -> {
                System.out.println(to + "-" + path);
            });
            System.out.println("----------------------");
        });
    }

}
