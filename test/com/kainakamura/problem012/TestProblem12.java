package com.kainakamura.problem012;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestProblem12 {
    @Test
    public void testNumDivisors() {
        assertEquals(1, Problem12.numDivisors(1));  // 1
        assertEquals(2, Problem12.numDivisors(3));  // 1,3
        assertEquals(4, Problem12.numDivisors(6));  // 1,2,3,6
        assertEquals(4, Problem12.numDivisors(10)); // 1,2,5,10
        assertEquals(4, Problem12.numDivisors(15)); // 1,3,5,15
        assertEquals(4, Problem12.numDivisors(21)); // 1,3,7,21
        assertEquals(6, Problem12.numDivisors(28)); // 1,2,4,7,14,28
    }
}
