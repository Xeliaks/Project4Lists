package com.example.project4lists;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class DoublyLinkedList<T> implements Iterable<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;


    private static class Node<T> {
        private T element;
        private Node<T> next;
        private Node<T> prev;

        public Node(Node<T> prev, T element, Node<T> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }


    private class ListIterator<T> implements Iterator<T> {
        private Node<T> current = (Node<T>) first;

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            T item = current.element;
            current = current.next;
            return item;
        }
    }


    public void add(T e) {
        addLast(e);
    }

    public void addFirst(T e) {
        Node<T> newNode = new Node<>(null, e, first);
        if (first == null) {
            last = newNode;
        } else {
            first.prev = newNode;
        }
        first = newNode;
        size++;
    }

    public void addLast(T e) {
        Node<T> newNode = new Node<>(last, e, null);
        if (last == null) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        size++;
    }

    public void add(int index, T e) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        if (index == 0) {
            addFirst(e);
        } else if (index == size) {
            addLast(e);
        } else {
            Node<T> current = getNode(index);
            Node<T> newNode = new Node<>(current.prev, e, current);
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
        }
    }

    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        Node<T> current = getNode(index);
        return current.element;
    }

    private Node<T> getNode(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }


    public void removeIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        Node<T> current = getNode(index);
        unlink(current);
    }
    public void removeValue(T e) {
        Node<T> current = first;
        while (current != null) {
            if (current.element.equals(e)) {
                unlink(current);
                return;
            }
            current = current.next;
        }
        throw new NoSuchElementException("Element not found in the list");
    }

    private void unlink(Node<T> node) {
        if (node.prev == null) {
            first = node.next;
        } else {
            node.prev.next = node.next;
        }
        if (node.next == null) {
            last = node.prev;
        } else {
            node.next.prev = node.prev;
        }
        size--;
    }



    public void removeAll(T e) {
        Node<T> current = first;
        while (current != null) {
            if (current.element.equals(e)) {
                Node<T> next = current.next;
                unlink(current);
                current = next;
            } else {
                current = current.next;
            }
        }
    }


    public int getSize() {
        return size;
    }



    @Override
    public Iterator<T> iterator() {
        return new ListIterator<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = first;
        while (current != null) {
            sb.append(current.element);
            if (current.next != null)
                sb.append(", ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public T getFirst() {
        if (isEmpty())
            throw new NoSuchElementException();
        return first.element;
    }

    public void removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();
        first = first.next;
        if (first == null) {
            last = null;
        } else {
            first.prev = null;
        }
        size--;
    }

    private boolean isEmpty() {
        return size == 0;
    }
    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return last.element;
    }
    public void removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        last = last.prev;
        if (last == null) {
            first = null;
        } else {
            last.next = null;
        }
        size--;
    }



    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();


        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("After add: " + list);


        list.addFirst(0);
        System.out.println("After addFirst: " + list);


        list.addLast(4);
        System.out.println("After addLast: " + list);


        list.add(3, 100);
        System.out.println("After add(3, 100): " + list);


        System.out.println("Element at index 3: " + list.get(3));


        list.removeIndex(3);
        System.out.println("After remove(100): " + list);


        list.removeValue(0);
        System.out.println("After remove(0): " + list);


        list.add(1);
        list.add(1);
        list.add(1);
        System.out.println("Adding ones: " + list);



        list.removeAll(1);
        System.out.println("After removeAll(1): " + list);


        System.out.print("Using iterator: ");
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
