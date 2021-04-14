package com.valid;

import com.valid.union.*;

public class Main {
    public static void main(String[] args) {
//        UnionFind unionFind = new UnionFindQuickFind(12);
//        UnionFind unionFind = new UnionFindQuickUnion(12);
//        UnionFind unionFind = new UnionFindQuickUnionSize(12);
//        UnionFind unionFind = new UnionFindQuickUnionRank(12);
//        UnionFind unionFind = new UnionFindQuickUnionRankPathCompress(12);
//        UnionFind unionFind = new UnionFindQuickUnionRankPathSplit(12);
//        unionFind.union(0, 1);
//        unionFind.union(0, 3);
//        unionFind.union(0, 4);
//        unionFind.union(2, 3);
//        unionFind.union(2, 5);
//
//        unionFind.union(6, 7);
//
//        unionFind.union(8, 9);
//        unionFind.union(8, 10);
//        unionFind.union(9, 11);
//        System.out.println(unionFind.isSame(0, 5));
//        System.out.println(unionFind.isSame(6, 9));
//
//        unionFind.union(4, 6);
//
//        unionFind.union(7, 11);

        GenericUnionFind<Student> unionFind = new GenericUnionFind<>();
        Student stu1 = new Student(10, "jack");
        Student stu2 = new Student(18, "rose");
        unionFind.makeSet(stu1);
        unionFind.makeSet(stu2);
        unionFind.union(stu1, stu2);

        Student stu3 = new Student(11, "tom");
        Student stu4 = new Student(30, "alice");
        unionFind.makeSet(stu3);
        unionFind.makeSet(stu4);
        unionFind.union(stu3, stu4);

        System.out.println(unionFind.isSame(stu1, stu2));
    }
}
