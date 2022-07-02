package com.kainakamura.problem011;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Scanner;

/**
 * What is the greatest product of four adjacent numbers in the same direction
 * (up, down, left, right, or diagonally) in the 20×20 grid?
 */
public class Problem11 {
    private static final String PATH = "src/com/kainakamura/problem011";

    protected static double largestProductInAGrid(int n) {
        int[][] grid = loadGrid();

//        return Math.max(
//            largestHorizontalProduct(n, grid),
//            largestVerticalProduct(n, grid),
//            largestDiagonalProduct(n, grid)
//        );
        return largestHorizontalProduct(n, grid);
    }

    protected static double largestHorizontalProduct(int n, int[][] grid) {
        double largestProduct = 0;

        for (int i = 0; i < grid.length - n; i++) {
            double product = 1;
            for (int j = i; j < i + n; j++) {
                int digit = grid[i][j];
                // If digit is zero, product will always be zero
                if (digit == 0) {
                    product = 0;
                    break;
                }
                product *= digit;
            }

            if (product > largestProduct) {
                largestProduct = product;
            }
        }

        return largestProduct;
    }

    protected static int[][] loadGrid() {
        int[][] grid = new int[20][20];
        File file = new File(PATH + "/grid.txt");
        try {
            InputStream inputStream = Files.newInputStream(file.toPath());
            Scanner scanner = new Scanner(inputStream);
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    grid[i][j] = scanner.nextInt();
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to read grid: " + e.getMessage());
        }
        return grid;
    }

    public static void main(String[] args) {
        System.out.println(largestProductInAGrid(4));
    }
}
