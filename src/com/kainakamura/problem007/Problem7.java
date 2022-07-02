package com.kainakamura.problem007;

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
 * that the 6th prime is 13.
 *
 * What is the 10,001st prime number?
 */
public class Problem7 {
    protected static int getPrimeByOrdinal(int n) {
        int i = 1;
        int primeCount = 0;
        while (primeCount < n) {
            i++;
            if (isPrime(i)) {
                primeCount++;
            }
        }
        return i;
    }

    protected static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(getPrimeByOrdinal(6));
        System.out.println(getPrimeByOrdinal(10001));
    }
}
