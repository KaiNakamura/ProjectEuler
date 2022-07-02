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

    protected static double largestProductInAGrid(int[][] grid, int n) {
        return Math.max(
            largestProduct(new HorizontalGridIterator(grid, n)),
            Math.max(
                largestProduct(new VerticalGridIterator(grid, n)),
                Math.max(
                    largestProduct(new DiagonalRightGridIterator(grid, n)),
                    largestProduct(new DiagonalLeftGridIterator(grid, n))
                )
            )
        );
    }

    protected static double largestProduct(GridIterator gridIterator) {
        double largestProduct = 0;

        while (gridIterator.hasNext()) {
            int product = 1;
            for (int digit : gridIterator.next()) {
                product *= digit;
                if (product == 0) {
                    break;
                }
            }

            if (product > largestProduct) {
                largestProduct = product;
            }
        }

        return largestProduct;
    }

    protected static int[][] loadGrid(String fileName, int gridSize) {
        int[][] grid = new int[gridSize][gridSize];
        File file = new File(PATH + "/" + fileName);
        try {
            InputStream inputStream = Files.newInputStream(file.toPath());
            Scanner scanner = new Scanner(inputStream);
            for (int i = 0; i < gridSize; i++) {
                for (int j = 0; j < gridSize; j++) {
                    grid[i][j] = scanner.nextInt();
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to read grid: " + e.getMessage());
        }
        return grid;
    }

    public static void main(String[] args) {
        System.out.println(largestProductInAGrid(loadGrid("grid.txt", 20), 4));
    }
}
