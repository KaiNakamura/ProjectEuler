package com.kainakamura.problem011;

import java.util.Iterator;

public abstract class GridIterator implements Iterator<int[]> {
    protected int[][] grid;
    protected int n;
    protected int row, col;
    protected boolean hasNext;

    public GridIterator(int[][] grid, int n) {
        this.grid = grid;
        this.n = n;
        row = 0;
        col = 0;
        hasNext = grid.length != 0;
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }

    @Override
    public int[] next() {
        int[] next = getDigits();

        if (hasNextCol()) {
            col++;
        }
        else if (hasNextRow()) {
            row++;
            col = 0;
        }
        else {
            hasNext = false;
        }

        return next;
    }

    protected abstract boolean hasNextRow();

    protected abstract boolean hasNextCol();

    protected abstract int[] getDigits();
}
