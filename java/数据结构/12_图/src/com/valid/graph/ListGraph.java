package com.valid.graph;

import java.util.*;

public class ListGraph<V, E> implements Graph<V, E>{
    private Map<V, Vertex<V, E>> vertices = new HashMap<>(); //存储顶点
    private Set<Edge<V, E>> edges = new HashSet<>(); // 存储边信息

    @Override
    public int edgesSize() {
        return edges.size();
    }

    @Override
    public int verticesSize() {
        return vertices.size();
    }

    @Override
    public void addVertex(V v) {
        if (!vertices.containsKey(v)) {
            vertices.put(v, new Vertex<>(v));
        }
    }

    @Override
    public void addEdge(V from, V to) {
        addEdge(from, to, null);
    }

    @Override
    public void addEdge(V from, V to, E weight) {
        // 判断from和to是否在已经被添加进去
        Vertex<V, E> fromVertex = vertices.get(from);
        if (fromVertex == null) {
            fromVertex = new Vertex<>(from);
            vertices.put(from, fromVertex);
        }

        Vertex<V, E> toVertex = vertices.get(to);
        if (toVertex == null) {
            toVertex = new Vertex<>(to);
            vertices.put(to, toVertex);
        }

        // 创建一条边
        Edge<V, E> edge = new Edge<>(fromVertex, toVertex, weight);
        if (fromVertex.outEdges.remove(edge)) {
            // 如果存在则从边的集合中移除这条边
            toVertex.inEdges.remove(edge);

            edges.remove(edge);
        }

        // 将边添加至边的集合
        fromVertex.outEdges.add(edge);
        toVertex.inEdges.add(edge);
        edges.add(edge);
    }

    @Override
    public void removeVertex(V v) {
        // 从顶点集中删除待删除的定点
        Vertex<V, E> vertex = vertices.remove(v);
        if (vertex == null) return; // 返回为空，说明待删除的节点不存在

        Iterator<Edge<V, E>> iterator = vertex.outEdges.iterator();
        while(iterator.hasNext()) {
            Edge<V, E> edge = iterator.next();
            // 删除当前边的终点里的入边
            edge.to.inEdges.remove(edge);
            iterator.remove(); // 删除当前遍历到的边
            edges.remove(edge);
        }

        iterator = vertex.inEdges.iterator();
        while(iterator.hasNext()) {
            Edge<V, E> edge = iterator.next();
            // 删除当前边的终点里的出边
            edge.from.outEdges.remove(edge);
            iterator.remove(); // 删除当前遍历到的边
            edges.remove(edge);
        }
    }

    @Override
    public void removeEdge(V from, V to) {
        // 不存在的点直接返回即可
        Vertex<V, E> fromVertex = vertices.get(from);
        if (fromVertex == null) return;

        Vertex<V, E> toVertex = vertices.get(to);
        if (toVertex == null) return;

        Edge<V, E> edge = new Edge<>(fromVertex, toVertex);
        if (fromVertex.outEdges.remove(edge)) {
            toVertex.inEdges.remove(edge);
            edges.remove(edge);
        }
    }

    @Override
    public void bfs(V begin) {
        Vertex<V, E> vertex = vertices.get(begin);
        if (vertex == null) return;

        Set<Vertex<V, E>> visitedVertices = new HashSet<>(); // 存储已经访问过的节点
        Queue<Vertex<V, E>> queue = new LinkedList<>(); // 存储待访问的顶点
        queue.offer(vertex);
        visitedVertices.add(vertex);
        while (!queue.isEmpty()) {
            vertex = queue.poll();
            System.out.println(vertex.value);

            for(Edge<V, E> edge : vertex.outEdges) {
                if (!visitedVertices.contains(edge.to)) {
                    queue.offer(edge.to);
                    visitedVertices.add(edge.to);
                }
            }
        }
    }

    private static class Vertex<V, E>{
        V value;
        Set<Edge<V, E>> inEdges = new HashSet<>();; // 以当前节点为终点的边
        Set<Edge<V, E>> outEdges = new HashSet<>(); // 以当前节点为起点的边

        public Vertex(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            // 如果两个顶点存储的值相同，则认为这两个点是同一个点
            return Objects.equals(value, ((Vertex<V, E>)obj).value);
        }

        @Override
        public int hashCode() {
            return value == null ? 0 : value.hashCode();
        }
    }
    private static class Edge<V, E>{
        Vertex<V, E> from; // 边的起点
        Vertex<V, E> to; // 边的终点
        E weight;

        public Edge(Vertex<V, E> from, Vertex<V, E> to) {
            this(from, to, null);
        }

        public Edge(Vertex<V, E> from, Vertex<V, E> to, E weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public boolean equals(Object obj) {
            Edge<V, E> edge = (Edge<V, E>) obj;
            // 如果一条边的起始和终点相同，则认为是同一条边
            return Objects.equals(from, edge.from) && Objects.equals(to, edge.to);
        }

        @Override
        public int hashCode() {
            return from.hashCode() * 31 + to.hashCode();
        }
    }
}
