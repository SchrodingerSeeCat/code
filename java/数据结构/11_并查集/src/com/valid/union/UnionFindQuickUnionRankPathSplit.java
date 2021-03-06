package com.valid.union;

// 路径分裂
public class UnionFindQuickUnionRankPathSplit extends UnionFind{
    private final int[] ranks;
    public UnionFindQuickUnionRankPathSplit(int capacity) {
        super(capacity);
        ranks = new int[capacity];
        for(int i = 0; i < capacity; i++) {
            ranks[i] = 1;
        }
    }

    @Override
    public int find(int v) {
        rangeCheck(v);
        while (v != parents[v]){
            parents[v] = parents[parents[v]]; // 执行祖父节点
            v = parents[v];
        }
        return v;
    }

    @Override
    public void union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);

        if (p1 == p2) return;

        if (ranks[p1] < ranks[p2]) {
            parents[p1] = p2;
        } else if (ranks[p1] > ranks[p2]){
            parents[p2] = p1;
        } else {
            parents[p1] = p2;
            ranks[p2] += 1;
        }
    }
}
