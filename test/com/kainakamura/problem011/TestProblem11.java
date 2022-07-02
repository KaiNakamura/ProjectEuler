package com.kainakamura.problem011;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestProblem11 {
    private int[][] testGrid;

    @Before
    public void setup() {
        testGrid = Problem11.loadGrid("test-grid.txt", 4);
    }

    @Test
    public void testHorizontalGridIterator() {
        HorizontalGridIterator gi = new HorizontalGridIterator(testGrid, 3);

        assertTrue(gi.hasNext());
        assertArrayEquals(new int[]{1, 2, 3}, gi.next());
        assertTrue(gi.hasNext());
        assertArrayEquals(new int[]{2, 3, 4}, gi.next());
        assertTrue(gi.hasNext());
        assertArrayEquals(new int[]{5, 6, 7}, gi.next());
        assertTrue(gi.hasNext());
        assertArrayEquals(new int[]{6, 7, 8}, gi.next());
        assertTrue(gi.hasNext());
        assertArrayEquals(new int[]{9, 10, 11}, gi.next());
        assertTrue(gi.hasNext());
        assertArrayEquals(new int[]{10, 11, 12}, gi.next());
        assertTrue(gi.hasNext());
        assertArrayEquals(new int[]{13, 14, 15}, gi.next());
        assertTrue(gi.hasNext());
        assertArrayEquals(new int[]{14, 15, 16}, gi.next());
        assertFalse(gi.hasNext());
    }

    @Test
    public void testVerticalGridIterator() {
        VerticalGridIterator gi = new VerticalGridIterator(testGrid, 3);

        assertTrue(gi.hasNext());
        assertArrayEquals(new int[]{1, 5, 9}, gi.next());
        assertTrue(gi.hasNext());
        assertArrayEquals(new int[]{2, 6, 10}, gi.next());
        assertTrue(gi.hasNext());
        assertArrayEquals(new int[]{3, 7, 11}, gi.next());
        assertTrue(gi.hasNext());
        assertArrayEquals(new int[]{4, 8, 12}, gi.next());
        assertTrue(gi.hasNext());
        assertArrayEquals(new int[]{5, 9, 13}, gi.next());
        assertTrue(gi.hasNext());
        assertArrayEquals(new int[]{6, 10, 14}, gi.next());
        assertTrue(gi.hasNext());
        assertArrayEquals(new int[]{7, 11, 15}, gi.next());
        assertTrue(gi.hasNext());
        assertArrayEquals(new int[]{8, 12, 16}, gi.next());
        assertFalse(gi.hasNext());
    }

    @Test
    public void testDiagonalRightGridIterator() {
        DiagonalRightGridIterator gi =
            new DiagonalRightGridIterator(testGrid, 3);

        assertTrue(gi.hasNext());
        assertArrayEquals(new int[]{1, 6, 11}, gi.next());
        assertTrue(gi.hasNext());
        assertArrayEquals(new int[]{2, 7, 12}, gi.next());
        assertTrue(gi.hasNext());
        assertArrayEquals(new int[]{5, 10, 15}, gi.next());
        assertTrue(gi.hasNext());
        assertArrayEquals(new int[]{6, 11, 16}, gi.next());
        assertFalse(gi.hasNext());
    }

    @Test
    public void testDiagonalLeftGridIterator() {
        DiagonalLeftGridIterator gi =
            new DiagonalLeftGridIterator(testGrid, 3);

        assertTrue(gi.hasNext());
        assertArrayEquals(new int[]{3, 6, 9}, gi.next());
        assertTrue(gi.hasNext());
        assertArrayEquals(new int[]{4, 7, 10}, gi.next());
        assertTrue(gi.hasNext());
        assertArrayEquals(new int[]{7, 10, 13}, gi.next());
        assertTrue(gi.hasNext());
        assertArrayEquals(new int[]{8, 11, 14}, gi.next());
        assertFalse(gi.hasNext());
    }
}
