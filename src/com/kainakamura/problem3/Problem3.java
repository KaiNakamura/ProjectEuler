package com.kainakamura.problem3;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143?
 */
public class Problem3 {
    protected static double largestPrimeFactor(double n) {
        double largestPrimeFactor = 0;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return Math.max(largestPrimeFactor, largestPrimeFactor(n / i));
            }
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(largestPrimeFactor(13195));
        System.out.println(largestPrimeFactor(600851475143d));
    }
}
