package com.valid.graph;

import com.valid.heap.BinaryHeap;
import com.valid.union.UnionFind;

import javax.xml.stream.events.EntityReference;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Predicate;

public class ListGraph<V, E> extends Graph<V, E>{
    private final Map<V, Vertex<V, E>> vertices = new HashMap<>(); //存储顶点
    private final Set<Edge<V, E>> edges = new HashSet<>(); // 存储边信息

    public ListGraph(WeightManager<E> weightManager) {
        super(weightManager);
    }

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
    public void addUndirectedEdge(V from, V to, E weight) {
        addEdge(from, to, weight);
        addEdge(to, from, weight);
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
    public void bfs(V begin, Predicate<V> consumer) {
        Vertex<V, E> vertex = vertices.get(begin);
        if (vertex == null) return;

        Set<Vertex<V, E>> visitedVertices = new HashSet<>(); // 存储已经访问过的节点
        Queue<Vertex<V, E>> queue = new LinkedList<>(); // 存储待访问的顶点
        queue.offer(vertex);
        visitedVertices.add(vertex);
        while (!queue.isEmpty()) {
            vertex = queue.poll();
            if (consumer.test(vertex.value)) break; // 如果返回值为true则退出

            for(Edge<V, E> edge : vertex.outEdges) {
                if (!visitedVertices.contains(edge.to)) {
                    queue.offer(edge.to);
                    visitedVertices.add(edge.to);
                }
            }
        }
    }

    // 递归
//    @Override
//    public void dfs(V begin, Predicate<V> consumer) {
//        Vertex<V, E> vertex = vertices.get(begin);
//        if (vertex == null) return;
//        dfs(vertex, new HashSet<>(), consumer); // HashSet存储已经访问过的节点
//    }
//
//    private void dfs(Vertex<V, E> vertex, Set<Vertex<V, E>> visited, , Predicate<V> consumer) {
//        consumer.test(vertex.value);
//        vertex.outEdges.forEach(edge -> {
//            if (!visited.contains(edge.to)) {
//                dfs(edge.to, visited, consumer);
//                visited.add(edge.to);
//            }
//        });
//    }

    // 非递归
    @Override
    public void dfs(V begin, Predicate<V> consumer) {
        Vertex<V, E> vertex = vertices.get(begin);
        if (vertex == null) return;
        Set<Vertex<V, E>> visited = new HashSet<>(); // HashSet存储已经访问过的节点
        Stack<Vertex<V, E>> stack = new Stack<>(); // 存储需要回溯的节点

        // 访问根节点
        stack.push(vertex);
        visited.add(vertex);
        if (consumer.test(vertex.value)) return;

        while (!stack.empty()) {
            vertex = stack.pop();

            for(Edge<V, E> edge : vertex.outEdges) {
                if(!visited.contains(edge.to)) {
                    stack.push(edge.from); // 保存根节点以便回溯
                    stack.push(edge.to);
                    visited.add(edge.to);
                    if (consumer.test(edge.to.value)) return;
                    break;
                }
            }
        }
    }

    // 拓扑排序
    @Override
    public List<V> topologicalSort() {
        if (verticesSize() == 0) return null;
        List<V> list = new ArrayList<>();
        Queue<Vertex<V, E>> queue = new LinkedList<>();

        Map<Vertex<V, E>, Integer> degrees = new HashMap();
        // 初始化(将度为0的节点都入队)
        vertices.forEach((V v, Vertex<V, E> vertex) -> {
            if (vertex.inEdges.size() == 0) {
                queue.offer(vertex);
            } else {
                // 维护每个入度不为零的节点的入度数
                degrees.put(vertex, vertex.inEdges.size());
            }
        });

        Vertex<V, E> vertex;
        while (!queue.isEmpty()) {
            vertex = queue.poll();
            list.add(vertex.value);
            for(Edge<V, E> edge : vertex.outEdges) {
                // 更改入度
                int to = degrees.get(edge.to) - 1;
                if (to == 0) {
                    queue.offer(edge.to);
                } else {
                    degrees.put(edge.to, to); // 更改入度
                }
            }
        }

        return list.size() == verticesSize() ? list : null;
    }

    // 最小生成树
    @Override
    public Set<EdgeInfo<V, E>> mst() {
        return kruskal();
    }

    // 单源点最短路径
    @Override
    public Map<V, PathInfo<V, E>> shortestPath(V begin) {
        return bellmanFord(begin);
    }

    // 多源最短路径
    @Override
    public Map<V, Map<V, PathInfo<V, E>>> shortestPath() {
        Map<V, Map<V, PathInfo<V, E>>> paths = new HashMap<>();
        // 初始化
        for (Edge<V, E> edge : edges) {
            Map<V, PathInfo<V, E>> map = paths.get(edge.from.value);
            if (map == null) {
                map = new HashMap<>();
                paths.put(edge.from.value, map);
            }

            PathInfo<V, E> pathInfo = new PathInfo<>(edge.weight);
            pathInfo.edgeInfos.add(edge.info());
            map.put(edge.to.value, pathInfo);
        }

        vertices.forEach((V v2, Vertex<V, E> vertex2) -> {
            vertices.forEach((V v1, Vertex<V, E> vertex1) -> {
                vertices.forEach((V v3, Vertex<V, E> vertex3) -> {
                    if (v1.equals(v2) || v2.equals(v3) || v1.equals(v3)) return;

                    // v1 -> v2
                    PathInfo<V, E> path1 = getPathInfo(v1, v2, paths);
                    if (path1 == null) return;

                    // v2 -> v3
                    PathInfo<V, E> path2 = getPathInfo(v2, v3, paths);
                    if (path2 == null) return;

                    // v1 -> v3
                    PathInfo<V, E> path3 = getPathInfo(v1, v3, paths);

                    E newWeight = weightManager.add(path1.weight, path2.weight);
                    if (path3 != null && weightManager.compare(newWeight, path3.weight) > 0) return;

                    if (path3 == null) { // 原本Map中不存在
                        path3 = new PathInfo<>();
                        paths.get(v1).put(v3, path3);
                    } else {
                        path3.edgeInfos.clear();
                    }

                    // 更新路径信息
                    path3.weight = newWeight;
                    path3.edgeInfos.addAll(path1.edgeInfos);
                    path3.edgeInfos.addAll(path2.edgeInfos);
                });
            });
        });

        return paths;
    }
    private PathInfo<V, E> getPathInfo(V from, V to, Map<V, Map<V, PathInfo<V, E>>> paths) {
        Map<V, PathInfo<V, E>> map = paths.get(from);
        return map == null ? null : map.get(to);
    }

    // dijkstra算法
    private Map<V, PathInfo<V, E>> dijkstra(V begin) {
        Vertex<V, E> vertex = vertices.get(begin);
        if (vertex == null) return null;

        // 存储各顶点之间的最短路径
        Map<V, PathInfo<V, E>> selectedPaths = new HashMap<>();
        Map<Vertex<V, E>, PathInfo<V, E>> paths = new HashMap<>();

        // 初始化
        paths.put(vertex, new PathInfo<>(weightManager.zero()));

        while (!paths.isEmpty()) {
            Map.Entry<Vertex<V, E>, PathInfo<V, E>> minEntry = getMinPath(paths);
            Vertex<V, E> minVertex = minEntry.getKey();

            selectedPaths.put(minVertex.value, minEntry.getValue());
            paths.remove(minVertex);
            // 对outEdges进行松弛操作
            for(Edge<V, E> edge : minVertex.outEdges) {
                // 如果edge.to已经被选中或者edge.to是vertex，没有必要进行松弛操作
                if (selectedPaths.containsKey(edge.to.value)) continue;
                relaxationForDijkstra(edge, minEntry.getValue(), paths);
            }
        }
        selectedPaths.remove(vertex.value);
        return selectedPaths;
    }

    private void relaxationForDijkstra(
            Edge<V, E> edge,
            PathInfo<V, E> minPath,
            Map<Vertex<V, E>, PathInfo<V, E>> paths) {
        // 新的路径
        E newWeight = weightManager.add(minPath.weight, edge.weight);
        // 以前的路径，可能没有取出为null
        PathInfo<V, E> oldPath = paths.get(edge.to);

        if (oldPath != null && weightManager.compare(newWeight, oldPath.weight) >= 0) return;

        if (oldPath == null) {
            oldPath = new PathInfo<>();
            paths.put(edge.to, oldPath);
        } else {
            oldPath.edgeInfos.clear(); // 清除原本的路径
        }

        oldPath.weight = newWeight; // 更改权重
        oldPath.edgeInfos.addAll(minPath.edgeInfos); // 更改路径
        oldPath.edgeInfos.add(edge.info());
    }
    // Bellman-Ford
    private Map<V, PathInfo<V, E>> bellmanFord(V begin) {
        Vertex<V, E> vertex = vertices.get(begin);
        if (vertex == null) return null;

        // 存储各顶点之间的最短路径
        Map<V, PathInfo<V, E>> selectedPaths = new HashMap<>();
        selectedPaths.put(begin, new PathInfo<>(weightManager.zero())); // 放入起点信息并赋初值零

        // 松弛的次数
        int count = vertices.size() - 1;
        for(int i = 0; i < count; i++) {
            for (Edge<V, E> edge : edges) {
                PathInfo<V, E> fromPath = selectedPaths.get(edge.from.value);
                if (fromPath == null) continue;
                relaxationForBellmanFord(edge, fromPath, selectedPaths);
            }
        }

        for (Edge<V, E> edge : edges) {
            PathInfo<V, E> fromPath = selectedPaths.get(edge.from.value);
            if (fromPath == null) continue;
            if (relaxationForBellmanFord(edge, fromPath, selectedPaths)) {
                throw new IllegalArgumentException("有负权环"); // 存在负权环，没有最短路径
            }
        }

        selectedPaths.remove(begin);
        return selectedPaths;
    }

    // BellmanFord松弛操作
    private boolean relaxationForBellmanFord(
            Edge<V, E> edge,
            PathInfo<V, E> minPath,
            Map<V, PathInfo<V, E>> paths) {
        // 新的路径
        E newWeight = weightManager.add(minPath.weight, edge.weight);
        // 以前的路径，可能没有取出为null
        PathInfo<V, E> oldPath = paths.get(edge.to.value);

        if (oldPath != null && weightManager.compare(newWeight, oldPath.weight) >= 0) return false;

        if (oldPath == null) {
            oldPath = new PathInfo<>();
            paths.put(edge.to.value, oldPath);
        } else {
            oldPath.edgeInfos.clear(); // 清除原本的路径
        }

        oldPath.weight = newWeight; // 更改权重
        oldPath.edgeInfos.addAll(minPath.edgeInfos); // 更改路径
        oldPath.edgeInfos.add(edge.info());
        return true;
    }

    // 查找最小的顶点
    private Map.Entry<Vertex<V, E>, PathInfo<V, E>> getMinPath(Map<Vertex<V, E>, PathInfo<V, E>> paths) {
        if (paths == null || paths.size() == 0) return null;

        Iterator<Map.Entry<Vertex<V, E>, PathInfo<V, E>>> iterator = paths.entrySet().iterator();
        Map.Entry<Vertex<V, E>, PathInfo<V, E>> minEntry = iterator.next();

        while (iterator.hasNext()) {
            Map.Entry<Vertex<V, E>, PathInfo<V, E>> entry = iterator.next();
            if (weightManager.compare(entry.getValue().weight, minEntry.getValue().weight) < 0) {
                minEntry = entry;
            }
        }
        return minEntry;
    }

    // 边的比较器
    private final Comparator<Edge<V, E>> edgeComparator = (Edge<V, E> e1, Edge<V, E> e2) -> {
        return -weightManager.compare(e1.weight, e2.weight);
    };
    private Set<EdgeInfo<V, E>> prim() {

        // 先拿到起始节点
        Iterator<Vertex<V, E>> iterator = vertices.values().iterator();
        if (!iterator.hasNext()) return null;
        Vertex<V, E> vertex = iterator.next();
        Set<EdgeInfo<V, E>> edgeInfos = new HashSet<>(); // 最终要返回的边的信息
        Set<Vertex<V, E>> addedVertices = new HashSet<>(); // 已经添加的顶点
        addedVertices.add(vertex);

        // 将出度边集合转换为数组
        Edge<V, E>[] edges = setConversionArray(vertex.outEdges);
        BinaryHeap<Edge<V, E>> heap = new BinaryHeap<>(edges, edgeComparator);

        // 最小生成树的边的数量
        int edgeSize = verticesSize() - 1;
        while (!heap.isEmpty() && edgeInfos.size() < edgeSize) {
            Edge<V, E> edge = heap.remove();
            if (addedVertices.contains(edge.to)) continue;

            // 将最小的边放入到边信息中
            edgeInfos.add(edge.info());
            addedVertices.add(edge.to);

            // 将to的出度放入到heap中
            for(Edge<V, E> to : edge.to.outEdges) {
                heap.add(to);
            }
        }

        return edgeInfos;
    }
    private Set<EdgeInfo<V, E>> kruskal() {
        if(verticesSize() == 0) return null; // 图中没有顶点
        Set<EdgeInfo<V, E>> edgeInfos = new HashSet<>();

        // 将所有边加入到小顶堆中
        BinaryHeap<Edge<V, E>> heap = new BinaryHeap<>(setConversionArray(edges), edgeComparator);

        // 创建并查集集合
        UnionFind<Vertex<V, E>> union = new UnionFind<>();
        vertices.forEach((V key, Vertex<V, E> value) -> {
            union.makeSet(value);
        });

        int edgeSize = verticesSize() - 1;
        while(!heap.isEmpty() && edgeInfos.size() < edgeSize) {
            Edge<V, E> edge = heap.remove();

            // 忽略会构成环的边
            if (union.isSame(edge.from, edge.to)) continue;

            edgeInfos.add(edge.info());
            union.union(edge.from, edge.to); // 将最小边的两个顶点放入到同一个集合中
        }

        return edgeInfos;
    }

    // 集合转换为数组
    private Edge<V, E>[] setConversionArray(Set<Edge<V, E>> collection) {
        if (collection.size() == 0) return null;
        Edge<V, E>[] elements = new Edge[collection.size()];
        int i = 0;
        for(Edge<V, E> element : collection) {
            elements[i++] = element;
        }
        return elements;
    }

    // 顶点信息
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

    // 边信息
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

        // 返回边的信息
        public EdgeInfo<V, E> info() {
            return new EdgeInfo<>(from.value, to.value, weight);
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
