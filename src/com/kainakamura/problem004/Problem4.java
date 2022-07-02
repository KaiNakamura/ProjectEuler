package com.kainakamura.problem004;

/**
 * A palindromic number reads the same both ways. The largest palindrome made
 * from the product of two 2-digit numbers is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Problem4 {
    protected static int largestPalindromeProduct(int n) {
        int largestPalindromeProduct = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i; j < n; j++) {
                int product = i * j;
                if (
                    product > largestPalindromeProduct &&
                    isPalindrome(product)
                ) {
                    largestPalindromeProduct = product;
                }
            }
        }
        return largestPalindromeProduct;
    }

    /**
     * Check whether a number is a palindrome or not
     * @param n The number to check
     * @return If the number is a palindrome
     */
    protected static boolean isPalindrome(int n) {
        return n == reverse(n);
    }

    /**
     * Reverse an integer (e.g. 12345 becomes 54321)
     * @param n The number to reverse
     * @return The reversed number
     */
    protected static int reverse(int n) {
        int reverse = 0;

        while (n != 0) {
            reverse *= 10;
            reverse += n % 10;
            n /= 10;
        }

        return reverse;
    }

    public static void main(String[] args) {
        System.out.println(largestPalindromeProduct(100));
        System.out.println(largestPalindromeProduct(1000));
    }
}
