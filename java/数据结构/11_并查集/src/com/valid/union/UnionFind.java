package com.valid.union;

public abstract class UnionFind {
    protected int[] parents;
    public UnionFind(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }

        parents = new int[capacity];
        for(int i = 0; i < parents.length; i++) {
            // 初始时每个节点的根节点都是它自己
            parents[i] = i;
        }
    }

    // 查找v所属集合的根节点
    public abstract int find(int v);

    // 检查v1、v2是否属于同一个集合
    public boolean isSame(int v1, int v2) {
        return find(v1) == find(v2);
    }

    // 合并v1、v2所在的集合
    public abstract void union(int v1, int v2);
    // 检查索引是否合法
    protected void rangeCheck(int v) {
        if(v >= parents.length || v < 0) {
            throw new IllegalArgumentException("v is out of bounds");
        }
    }
}
