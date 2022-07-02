package com.kainakamura.problem009;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, where:
 * a^2 + b^2 = c^2
 *
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
public class Problem9 {
    protected static double specialPythagoreanTriplet(int targetSum) {
        for (int c = 2; c < targetSum; c++) {
            for (int a = 1; a < c; a++) {
                for (int b = a; b < c; b++) {
                    if (
                        a + b + c == targetSum &&
                        isPythagoreanTriplet(a, b, c)
                    ) {
                        return a * b * c;
                    }
                }
            }
        }

        return 0;
    }

    protected static boolean isPythagoreanTriplet(int a, int b, int c) {
        return a * a + b * b == c * c;
    }

    public static void main(String[] args) {
        System.out.println(specialPythagoreanTriplet(3 + 4 + 5));
        System.out.println(specialPythagoreanTriplet(1000));
    }
}
