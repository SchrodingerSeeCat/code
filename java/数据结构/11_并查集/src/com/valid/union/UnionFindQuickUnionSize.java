package com.valid.union;

public class UnionFindQuickUnionSize extends UnionFind{
    private int[] sizes; // 存储每个集合的节点个数
    public UnionFindQuickUnionSize(int capacity) {
        super(capacity);
        sizes = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            sizes[i] = 1; // 初始时每个集合的节点个数都为1
        }
    }

    @Override
    public int find(int v) {
        rangeCheck(v);
        while (v != parents[v]){
            v = parents[v];
        }
        return v;
    }

    @Override
    public void union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);

        if (p1 == p2) return;

        if (sizes[p1] < sizes[p2]) { // p1集合的节点个数少
            parents[p1] = p2;
            sizes[p2] += sizes[p1];
        } else {
            parents[p2] = p1; // p2集合的节点个数多
            sizes[p1] += sizes[p2];
        }
    }
}
