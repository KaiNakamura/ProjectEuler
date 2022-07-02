package com.kainakamura.problem4;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestProblem4 {
    @Test
    public void testReverse() {
        assertEquals(1, Problem4.reverse(1));
        assertEquals(21, Problem4.reverse(12));
        assertEquals(321, Problem4.reverse(123));
        assertEquals(4321, Problem4.reverse(1234));
        assertEquals(1234, Problem4.reverse(Problem4.reverse(1234)));
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(Problem4.isPalindrome(1));
        assertTrue(Problem4.isPalindrome(11));
        assertTrue(Problem4.isPalindrome(121));
        assertTrue(Problem4.isPalindrome(1221));
        assertTrue(Problem4.isPalindrome(12321));

        assertFalse(Problem4.isPalindrome(12));
        assertFalse(Problem4.isPalindrome(21));
        assertFalse(Problem4.isPalindrome(123));
        assertFalse(Problem4.isPalindrome(1231));
        assertFalse(Problem4.isPalindrome(12331));
    }

    @Test
    public void testExample() {
        assertEquals(9009, Problem4.largestPalindromeProduct(100));
    }
}
