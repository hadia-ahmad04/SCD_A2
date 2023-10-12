
package com.mycompany.genericstack;


import java.util.EmptyStackException;

class GenericStack<T> {
    private Node<T> top;
    private int size;

    public GenericStack() {
        top = null;
        size = 0;
    }

    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T poppedItem = top.data;
        top = top.next;
        size--;
        return poppedItem;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public static void main(String[] args) {
        GenericStack<Object> stack = new GenericStack<>();
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.print("Enter Stack Size: ");
        int size = scanner.nextInt();

        System.out.println("Enter Stack Values:");
        for (int i = 0; i < size; i++) {
            Object item = scanner.next();
            stack.push(item);
        }

        System.out.println("Perform Stack Operations");
        while (true) {
            String operation = scanner.next();
            switch (operation) {
                case "push":
                    System.out.print("Value to push: ");
                    Object newItem = scanner.next();
                    stack.push(newItem);
                    break;
                    
                case "pop":
                    try {
                        Object poppedItem = stack.pop();
                        System.out.println("Popped: " + poppedItem);
                    } catch (EmptyStackException e) {
                        System.err.println("Error: Stack is empty");
                    }
                    break;
                case "size":
                    System.out.println("Stack size: " + stack.size());
                    break;
                case "isEmpty":
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty.");
                    } else {
                        System.out.println("Stack is not empty.");
                    }
                    break;
                case "quit":
                    System.out.println("Program Exited!");
                    scanner.close();
                    return;
                default:
                    System.err.println("Error: Invalid operation");
            }
        }
    }
}

