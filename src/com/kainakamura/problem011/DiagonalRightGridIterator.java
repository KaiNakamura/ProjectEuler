package com.kainakamura.problem011;

public class DiagonalRightGridIterator extends GridIterator {
    public DiagonalRightGridIterator(int[][] grid, int n) {
        super(grid, n);
    }

    @Override
    protected boolean hasNextRow() {
        return row < grid.length - n;
    }

    @Override
    protected boolean hasNextCol() {
        return col < grid.length - n;
    }

    @Override
    protected int[] getDigits() {
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) {
            digits[i] = grid[row + i][col + i];
        }
        return digits;
    }
}
