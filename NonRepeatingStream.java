
package com.mycompany.nonrepeatingstream;

import java.util.Scanner;

public class NonRepeatingStream {
    private static class Node {
        char data;
        Node prev;
        Node next;

        Node(char data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private Node[] charToNodeMap;

    public NonRepeatingStream() {
        head = new Node(' '); 
        tail = new Node(' '); 
        head.next = tail;
        tail.prev = head;
        charToNodeMap = new Node[256];
    }

    public void add(char c) {
        if (charToNodeMap[c] == null) {
            Node newNode = new Node(c);
            charToNodeMap[c] = newNode;
            addNode(newNode);
        } else if (charToNodeMap[c] != tail) {
            removeNode(charToNodeMap[c]);
            charToNodeMap[c] = tail;
        }
    }

    public char getFirstNonRepeatinStream() {
        if (head.next != tail) {
            return head.next.data;
        } else {
            return '-';
        }
    }

    private void addNode(Node newNode) {
        newNode.next = tail;
        newNode.prev = tail.prev;
        tail.prev.next = newNode;
        tail.prev = newNode;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public static void main(String[] args) {
        NonRepeatingStream stream = new NonRepeatingStream();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        for (char c : input.toCharArray()) {
            stream.add(c);
        }

        char firstNonRepeatinStream = stream.getFirstNonRepeatinStream();

        System.out.println("Current String: " + input);
        System.out.println("First Non-Repeating Character: " + firstNonRepeatinStream);
    }
}
