package com.valid.greedy.ks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Knapsack {

    // articles要装的物品
    // capacity背包的容量
    public List<Article> knapsack(
            Article[] articles,
            int capacity,
            Comparator<Article> comparator) {

        Arrays.sort(articles, comparator); // 排序
//        Arrays.sort(articles); // 排序
        System.out.println(Arrays.toString(articles));
        List<Article> list = new LinkedList<>(); // 保存添加的物品的信息

        int weight = 0; // 已经装载的重量
        int value = 0; // 已经装载的物品的价值
        for (Article article : articles) {
            if ((article.weight + weight) > capacity) {
                continue;
            }

            weight += article.weight;
            value += article.value;
            list.add(article);
        }

        System.out.println("物品: " + list + " 价值: " + value + " 重量: " + weight);

        return list;
    }

    public static class Article {
        private int weight; // 重量
        private int value; // 价值
        private double valueDensity; // 性价比

        public Article(int weight, int value) {
            this.weight = weight;
            this.value = value;
            valueDensity = value * 1.0 / weight;
        }

        public double getValueDensity() {
            return valueDensity;
        }

        @Override
        public String toString() {
            return "Article{" +
                    "weight=" + weight +
                    ", value=" + value +
                    ", valueDensity=" + valueDensity +
                    "}\n";
        }
    }
}
