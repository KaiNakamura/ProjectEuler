package com.kainakamura.problem013;

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.Stack;

/**
 * The four adjacent digits in the 1000-digit number that have the greatest
 * product are 9 × 9 × 8 × 9 = 5832.
 *
 * Find the thirteen adjacent digits in the 1000-digit number that have the
 * greatest product. What is the value of this product?
 */
public class Problem13 {
    private static final String PATH = "src/com/kainakamura/problem013";

    protected static class Node {
        private int value;
        private Node next;

        public Node() {}

        public Node(int value) {
            add(value);
        }

        void add(int amount) {
            value += amount;
            if (value >= 10) {
                int temp = value;
                value %= 10;
                if (next == null) {
                    next = new Node();
                }
                next.add(temp / 10);
            }
        }

        void add(Node other) {
            Node self = this;
            while (other != null) {
                self.add(other.getValue());
                other = other.next;
                if (other != null && self.next == null) {
                    self.next = new Node();
                }
                self = self.next;
            }
        }

        protected int getValue() {
            return value;
        }

        protected Node getNext() {
            return next;
        }

        protected int[] getSignificantFigures(int num) {
            Stack<Integer> stack = new Stack<>();
            Node node = this;
            while (node != null) {
                stack.push(node.value);
                node = node.next;
            }

            int[] significantFigures = new int[num];
            for (int i = 0; i < num; i++) {
                significantFigures[i] = stack.pop();
            }

            return significantFigures;
        }

        protected static Node createFromDigits(Stack<Integer> digits) {
            Node head = new Node();
            Node node = head;
            while (!digits.empty()) {
                node.value = digits.pop();
                if (!digits.empty()) {
                    node.next = new Node();
                    node = node.next;
                }
            }
            return head;
        }
    }

    public static int[] largeSum(Node[] numbers, int numSignificantFigures) {
        Node node = new Node();
        for (Node number : numbers) {
            node.add(number);
        }
        return node.getSignificantFigures(numSignificantFigures);
    }

    protected static Node[] loadNumbers(String fileName, int amount) {
        Node[] nodes = new Node[amount];
        File file = new File(PATH + "/" + fileName);
        try {
            InputStream inputStream = Files.newInputStream(file.toPath());
            Scanner scanner = new Scanner(inputStream).useDelimiter("");
            Stack<Integer> stack = new Stack<>();
            int i = 0;
            while (scanner.hasNext()) {
                String s = scanner.next();
                try {
                    stack.push(Integer.parseInt(s));
                } catch (NumberFormatException e) {
                    if (!stack.isEmpty()) {
                        nodes[i] = Node.createFromDigits(stack);
                        i++;
                    }
                }
            }
            if (!stack.isEmpty()) {
                nodes[i] = Node.createFromDigits(stack);
            }
        } catch (IOException e) {
            System.err.println("Failed to read numbers: " + e.getMessage());
        }
        return nodes;
    }

    protected static void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element);
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        printArray(largeSum(loadNumbers("numbers.txt", 100), 10));
    }
}
