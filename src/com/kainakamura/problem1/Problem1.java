package com.kainakamura.problem1;

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5,
 * we get 3, 5, 6 and 9. The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class Problem1 {
    /**
     * Returns the sum of all multiples of 3 or 5 below the given number n
     */
    protected static int multiplesOf3Or5(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(multiplesOf3Or5(10));
        System.out.println(multiplesOf3Or5(1000));
    }
}
