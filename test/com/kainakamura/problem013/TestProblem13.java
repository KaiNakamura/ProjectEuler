package com.kainakamura.problem013;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

public class TestProblem13 {
    @Test
    public void testAddInteger() {
        Problem13.Node node = new Problem13.Node();
        assertEquals(0, node.getValue());
        assertNull(node.getNext());
        node.add(9);
        assertEquals(9, node.getValue());
        assertNull(node.getNext());
        node.add(9);
        assertEquals(8, node.getValue());
        assertEquals(1, node.getNext().getValue());
        node.add(9);
        assertEquals(7, node.getValue());
        assertEquals(2, node.getNext().getValue());
        node.add(9);
        assertEquals(6, node.getValue());
        assertEquals(3, node.getNext().getValue());
        node.add(9);
        assertEquals(5, node.getValue());
        assertEquals(4, node.getNext().getValue());
        node.add(9);
        assertEquals(4, node.getValue());
        assertEquals(5, node.getNext().getValue());
        node.add(9);
        assertEquals(3, node.getValue());
        assertEquals(6, node.getNext().getValue());
        node.add(9);
        assertEquals(2, node.getValue());
        assertEquals(7, node.getNext().getValue());
        node.add(9);
        assertEquals(1, node.getValue());
        assertEquals(8, node.getNext().getValue());
        node.add(9);
        assertEquals(0, node.getValue());
        assertEquals(9, node.getNext().getValue());
        node.add(10);
        assertEquals(0, node.getValue());
        assertEquals(0, node.getNext().getValue());
        assertEquals(1, node.getNext().getNext().getValue());
    }

    @Test
    public void testAddNode() {
        Problem13.Node node1 = new Problem13.Node(16);
        Problem13.Node node2 = new Problem13.Node(26);
        node1.add(node2);
        assertEquals(2, node1.getValue());
        assertEquals(4, node1.getNext().getValue());

        node1 = new Problem13.Node(2);
        node2 = new Problem13.Node(24);
        node1.add(node2);
        assertEquals(6, node1.getValue());
        assertEquals(2, node1.getNext().getValue());

        node1 = new Problem13.Node(20);
        node2 = new Problem13.Node(4);
        node1.add(node2);
        assertEquals(4, node1.getValue());
        assertEquals(2, node1.getNext().getValue());
    }

    @Test
    public void testGetSignificantFigures() {
        Problem13.Node node = new Problem13.Node();
        node.add(1234567890);
        assertArrayEquals(
            new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9},
            node.getSignificantFigures(9)
        );
    }

    @Test
    public void testCreateFromDigits() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        Problem13.Node node = Problem13.Node.createFromDigits(stack);
        assertArrayEquals(
            new int[]{1, 2, 3, 4, 5},
            node.getSignificantFigures(5)
        );
    }

    @Test
    public void testLoadNumbers() {
        Problem13.Node[] nodes = Problem13.loadNumbers("test-numbers.txt", 3);
        assertArrayEquals(
            new Problem13.Node(123).getSignificantFigures(3),
            nodes[0].getSignificantFigures(3)
        );
        assertArrayEquals(
            new Problem13.Node(456).getSignificantFigures(3),
            nodes[1].getSignificantFigures(3)
        );
        assertArrayEquals(
            new Problem13.Node(789).getSignificantFigures(3),
            nodes[2].getSignificantFigures(3)
        );
    }
}
