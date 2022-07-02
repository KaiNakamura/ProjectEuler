package com.kainakamura.problem011;

public class DiagonalLeftGridIterator extends GridIterator {
    public DiagonalLeftGridIterator(int[][] grid, int n) {
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
            digits[i] = grid[row + i][col + n - 1 - i];
        }
        return digits;
    }
}
