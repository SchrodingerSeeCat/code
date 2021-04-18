package com.valid.graph;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public abstract class Graph<V, E> {
    public abstract int edgesSize(); // 边的个数
    public abstract int verticesSize(); // 点的个数

    public abstract void addVertex(V v); // 添加点
    public abstract void addEdge(V from, V to); // 添加边
    public abstract void addEdge(V from, V to, E weight); // 添加边
    public abstract void addUndirectedEdge(V from, V to, E weight); // 添加无向边

    public abstract void removeVertex(V v); // 删除点
    public abstract void removeEdge(V from, V to); // 删除边

    public abstract void bfs(V begin, Predicate<V> consumer); // 从begin开始进行广度优先遍历
    public abstract void dfs(V begin, Predicate<V> consumer); // 从begin开始进行深度优先遍历

    public abstract List<V> topologicalSort(); // 拓扑排序

    public abstract Set<EdgeInfo<V, E>> mst(); // 最小生成树
    // 边信息
    protected static class EdgeInfo<V, E> {
       private V from;
       private V to;
       private E weight;
       public EdgeInfo(V from, V to, E weight) {
           this.from = from;
           this.to = to;
           this.weight = weight;
       }

        @Override
        public String toString() {
            return "EdgeInfo{" +
                    "from=" + from +
                    ", to=" + to +
                    ", weight=" + weight +
                    "}\n";
        }
    }

    // 权重管理
    protected WeightManager<E> weightManager;
    public interface WeightManager<E> {
        int compare(E w1, E w2); // 比较
        E add(E w1, E w2); // 想加
    }
    public Graph(WeightManager<E> weightManager) {
        this.weightManager = weightManager;
    }
    public Graph() {}
}
