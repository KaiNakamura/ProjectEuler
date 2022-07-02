package com.kainakamura.problem011;

public class HorizontalGridIterator extends GridIterator {
    public HorizontalGridIterator(int[][] grid, int n) {
        super(grid, n);
    }

    @Override
    protected boolean hasNextRow() {
        return row < grid.length - 1;
    }

    @Override
    protected boolean hasNextCol() {
        return col < grid.length - n;
    }

    @Override
    protected int[] getDigits() {
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) {
            digits[i] = grid[row][col + i];
        }
        return digits;
    }
}
