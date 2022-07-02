package com.kainakamura.problem011.problem008;

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

/**
 * The four adjacent digits in the 1000-digit number that have the greatest
 * product are 9 × 9 × 8 × 9 = 5832.
 *
 * Find the thirteen adjacent digits in the 1000-digit number that have the
 * greatest product. What is the value of this product?
 */
public class Problem8 {
    private static final String PATH = "src/com/kainakamura/problem008";

    protected static double largestProductInASeries(int n) {
        double largestProduct = 0;
        int[] series = loadSeries();

        for (int i = 0; i < series.length - n; i++) {
            double product = 1;
            for (int j = i; j < i + n; j++) {
                int digit = series[j];
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

    protected static int[] loadSeries() {
        int[] series = new int[1000];
        File file = new File(PATH + "/1000-digit-number.txt");
        try {
            InputStream inputStream = Files.newInputStream(file.toPath());
            Scanner scanner = new Scanner(inputStream).useDelimiter("");
            int i = 0;
            while (scanner.hasNext()) {
                String s = scanner.next();
                try {
                    series[i] = Integer.parseInt(s);
                } catch (NumberFormatException e) {
                    continue;
                }
                i++;
            }
        } catch (IOException e) {
            System.err.println("Failed to read series: " + e.getMessage());
        }
        return series;
    }

    public static void main(String[] args) {
        System.out.println(largestProductInASeries(4));
        System.out.println(largestProductInASeries(13));
    }
}
