package com.valid.union;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GenericUnionFind<E> {
    // 用于存储所有的节点
    private final Map<E, Node<E>> nodes = new HashMap<>();

    // 创建一个集合
    public void makeSet(E v) {
        if (!nodes.containsKey(v)) {
            nodes.put(v, new Node<>(v));
        }
    }

    // 找出v的根节点
    private Node<E> findNode(E v) {
        Node<E> node = nodes.get(v);
        if (node == null) return null;

        // 路径减半算法
        while (!Objects.equals(node.value, node.parent.value)) {
            node.parent = node.parent.parent;
            node = node.parent;
        }

        return node;
    }

    public E find(E v) {
        Node<E> node = findNode(v);

        return node == null ? null : node.value;
    }

    public void union(E v1, E v2) {
        Node<E> p1 = findNode(v1);
        Node<E> p2 = findNode(v2);

        if (p1 == null || p2 == null) return;
        if (Objects.equals(p1.value, p2.value)) return;

        if (p1.rank < p2.rank) {
            p1.parent = p2;
        } else if (p1.rank > p2.rank) {
            p2.parent = p1;
        } else {
            p1.parent = p2;
            p2.rank++;
        }
    }

    public boolean isSame(E v1, E v2) {
        return Objects.equals(find(v1), find(v2));
    }

    // 集合中的节点对象
    private static class Node<E> {
        E value;
        Node<E> parent = this;
        int rank = 1;
        Node(E value) {
            this.value = value;
        }
    }
}
