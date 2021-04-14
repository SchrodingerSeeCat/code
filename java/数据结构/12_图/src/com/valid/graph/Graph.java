package com.valid.graph;

public interface Graph<V, E> {
    int edgesSize(); // 边的个数
    int verticesSize(); // 点的个数

    void addVertex(V v); // 添加点
    void addEdge(V from, V to); // 添加边
    void addEdge(V from, V to, E weight); // 添加边

    void removeVertex(V v); // 删除点
    void removeEdge(V from, V to); // 删除边

    void bfs(V begin); // 从begin开始进行广度优先遍历
}
