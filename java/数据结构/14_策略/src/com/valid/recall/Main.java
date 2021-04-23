package com.valid.recall;

import org.junit.jupiter.api.Test;

public class Main {
    private static final int n = 8;
    @Test
    void testPlaceQueens1() {
        new PlaceQueens1().placeQueens(n);
    }

    @Test
    void testPlaceQueens2() {
        new PlaceQueens2().placeQueens(n);
    }
}
