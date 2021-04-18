package com.valid;

import com.valid.graph.Graph;
import com.valid.graph.ListGraph;

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

        graph.addUndirectedEdge("A", "B", 17);
        graph.addUndirectedEdge("A", "F", 1);
        graph.addUndirectedEdge("A", "E", 16);

        graph.addUndirectedEdge("B", "C", 6);
        graph.addUndirectedEdge("B", "D", 5);
        graph.addUndirectedEdge("B", "F", 11);

        graph.addUndirectedEdge("C", "D", 10);

        graph.addUndirectedEdge("F", "E", 33);
        graph.addUndirectedEdge("F", "D", 14);

        graph.addUndirectedEdge("E", "D", 4);

        System.out.println(graph.mst());
    }

}
