package com.valid.graph;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public interface Graph<V, E> {
    int edgesSize(); // 边的个数
    int verticesSize(); // 点的个数

    void addVertex(V v); // 添加点
    void addEdge(V from, V to); // 添加边
    void addEdge(V from, V to, E weight); // 添加边

    void removeVertex(V v); // 删除点
    void removeEdge(V from, V to); // 删除边

    void bfs(V begin, Predicate<V> consumer); // 从begin开始进行广度优先遍历
    void dfs(V begin, Predicate<V> consumer); // 从begin开始进行深度优先遍历

    List<V> topologicalSort(); // 拓扑排序

    Set<EdgeInfo<V, E>> mst(); // 最小生成树
    // 边信息
    class EdgeInfo<V, E> {
       V from;
       V to;
       E weight;
       public EdgeInfo(V from, V to, E weight) {
           this.from = from;
           this.to = to;
           this.weight = weight;
       }
    }
}
