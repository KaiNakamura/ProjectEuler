package com.kainakamura.problem10;

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 */
public class Problem10 {
    protected static double summationOfPrimes(int n) {
        double sum = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }
        return sum;
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
        System.out.println(summationOfPrimes(10));
        System.out.println(summationOfPrimes(2000000));
    }
}
