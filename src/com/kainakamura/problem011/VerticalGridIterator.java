package com.kainakamura.problem011;

public class VerticalGridIterator extends GridIterator {
    public VerticalGridIterator(int[][] grid, int n) {
        super(grid, n);
    }

    @Override
    protected boolean hasNextRow() {
        return row < grid.length - n;
    }

    @Override
    protected boolean hasNextCol() {
        return col < grid.length - 1;
    }

    @Override
    protected int[] getDigits() {
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) {
            digits[i] = grid[row + i][col];
        }
        return digits;
    }
}
