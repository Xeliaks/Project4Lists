package com.example.project4lists;

import java.util.EmptyStackException;

public class Stack<T> extends DoublyLinkedList<T> {

    public void push(T e) {
        addFirst(e);
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T removedElement = getFirst();
        removeFirst();
        return removedElement;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return getFirst();
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();


        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack after push: " + stack);


        System.out.println("Popped element: " + stack.pop());
        System.out.println("Stack after pop: " + stack);


        System.out.println("Peeked element: " + stack.peek());
        System.out.println("Stack after peek: " + stack);


        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}
