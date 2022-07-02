package com.kainakamura.problem005;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from
 * 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all the
 * numbers from 1 to 20?
 */
public class Problem5 {
    protected static int smallestMultiple(int n) {
        int smallestMultiple = n;
        boolean isMultiple = false;
        while (!isMultiple) {
            smallestMultiple++;
            isMultiple = true;
            for (int i = 2; i < n; i++) {
                if (smallestMultiple % i != 0) {
                    isMultiple = false;
                    break;
                }
            }
        }
        return smallestMultiple;
    }

    public static void main(String[] args) {
        System.out.println(smallestMultiple(10));
        System.out.println(smallestMultiple(20));
    }
}
