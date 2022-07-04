package com.kainakamura.problem013;

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
public class Problem13 {
    private static final String PATH = "src/com/kainakamura/problem013";

    protected static int[] loadNumbers(String name) {
        int[] series = new int[1000];
        File file = new File(PATH + "/" + name);
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
    }
}
