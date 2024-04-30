package com.example.project4lists;

import java.util.NoSuchElementException;

public class Queue<T> extends DoublyLinkedList<T> {

    public void enqueue(T e) {
        addLast(e);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        T removedElement = getFirst();
        removeFirst();
        return removedElement;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return getFirst();
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }


    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();


        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("Queue after enqueue: " + queue);


        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Queue after dequeue: " + queue);


        System.out.println("Peeked element: " + queue.peek());
        System.out.println("Queue after peek: " + queue);


        System.out.println("Is queue empty? " + queue.isEmpty());
    }
}

