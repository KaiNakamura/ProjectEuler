package com.kainakamura.problem006;

/**
 * The sum of the squares of the first ten natural numbers is:
 * 1^2 + 2^2 + ... + 10^2 = 385
 *
 * The square of the sum of the first ten natural numbers is:
 * (1 + 2 + ... + 10)^2 = 55^2 = 3025
 *
 * Hence the difference between the sum of the squares of the first ten natural
 * numbers and the square of the sum is:
 * 3025 - 385 = 2640
 *
 * Find the difference between the sum of the squares of the first one hundred
 * natural numbers and the square of the sum:
 */
public class Problem6 {
    protected static int sumSquareDifference(int n) {
        return squareOfTheSum(n) - sumOfTheSquares(n);
    }

    protected static int sumOfTheSquares(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i * i;
        }
        return sum;
    }

    protected static int squareOfTheSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum * sum;
    }

    public static void main(String[] args) {
        System.out.println(sumSquareDifference(10));
        System.out.println(sumSquareDifference(100));
    }
}
