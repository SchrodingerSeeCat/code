package com.valid.greedy;

import com.valid.greedy.ks.Knapsack;
import com.valid.greedy.load.Load;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class Main {
    @Test
    public void testLoad() {
        System.out.println(new Load().maxNum(30, new int[]{3, 5, 4, 10, 10, 7, 2, 11}));;
    }

    @Test
    public void testKnapsack() {
        Knapsack.Article[] articles = new Knapsack.Article[] {
                new Knapsack.Article(35, 10),
                new Knapsack.Article(30, 40),
                new Knapsack.Article(60, 30),
                new Knapsack.Article(50, 50),
                new Knapsack.Article(40, 35),
                new Knapsack.Article(10, 40),
                new Knapsack.Article(25, 30)
        };

        new Knapsack().knapsack(articles, 150, new Comparator<Knapsack.Article>() {
            @Override
            public int compare(Knapsack.Article o1, Knapsack.Article o2) {
                return Double.compare(o2.getValueDensity(), o1.getValueDensity());
            }
        });
    }
}
