package com.valid;

import com.valid.graph.Graph;
import com.valid.graph.ListGraph;

public class Main {
    public static void main(String[] args) {
        Graph<String, Integer> graph = new ListGraph<>();
        graph.addEdge("V1", "V0", 9);
        graph.addEdge("V1", "V2", 3);
        graph.addEdge("V2", "V0", 2);
        graph.addEdge("V2", "V3", 5);
        graph.addEdge("V3", "V4", 1);
        graph.addEdge("V0", "V4", 6);

//        graph.removeEdge("V0", "V5");
//        graph.removeEdge("V0", "V4");

//        graph.removeVertex("V0");
//        graph.removeVertex("V1");

//        graph.bfs("V1");
//        graph.dfs("V1", value -> {
//            System.out.println(value);
//            return value.equals("V4");
//        });

        System.out.println(graph.topologicalSort());
    }

}
