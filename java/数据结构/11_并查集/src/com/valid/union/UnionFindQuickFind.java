package com.valid.union;

public class UnionFindQuickFind extends UnionFind{
    public UnionFindQuickFind(int capacity) {
        super(capacity);
    }

    // 查找v所属集合的根节点
    public int find(int v) {
        rangeCheck(v);
        return parents[v];
    }

    // 合并两个集合
    public void union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);
        if (p1 == p2) return;

        for(int i = 0; i < parents.length; i++) {
            if (parents[i] == p1) {
                parents[i] = p2;
            }
        }
    }
}
