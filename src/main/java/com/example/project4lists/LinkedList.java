package com.example.project4lists;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;


    private static class Node<T> {
        private T element;
        private Node<T> prev;
        private Node<T> next;

        public Node(Node<T> prev, T element, Node<T> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }
    }


    public LinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }


    public void add(T e) {
        addLast(e);
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


    public void add(int i, T e) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size);
        }
        if (i == size) {
            addLast(e);
            return;
        }
        Node<T> curr = getNode(i);
        Node<T> newNode = new Node<>(curr.prev, e, curr);
        if (curr.prev == null) {
            first = newNode;
        } else {
            curr.prev.next = newNode;
        }
        curr.prev = newNode;
        size++;
    }


    public T get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size);
        }
        return getNode(i).element;
    }


    public void remove(T e) {
        Node<T> current = first;
        while (current != null) {
            if (current.element.equals(e)) {
                if (current.prev == null) {
                    first = current.next;
                } else {
                    current.prev.next = current.next;
                }
                if (current.next == null) {
                    last = current.prev;
                } else {
                    current.next.prev = current.prev;
                }
                size--;
                return;
            }
            current = current.next;
        }
    }


    public void remove(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size);
        }
        Node<T> curr = getNode(i);
        if (curr.prev == null) {
            first = curr.next;
        } else {
            curr.prev.next = curr.next;
        }
        if (curr.next == null) {
            last = curr.prev;
        } else {
            curr.next.prev = curr.prev;
        }
        size--;
    }


    public void removeAll(T e) {
        Node<T> current = first;
        while (current != null) {
            if (current.element.equals(e)) {
                Node<T> next = current.next;
                remove(current.element);
                current = next;
            } else {
                current = current.next;
            }
        }
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


    public int getSize() {
        return size;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = first;
        while (current != null) {
            sb.append(current.element).append(" ");
            current = current.next;
        }
        return sb.toString().trim();
    }


    private Node<T> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }


    private class ListIterator implements Iterator<T> {
        private Node<T> current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T element = current.element;
            current = current.next;
            return element;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }


    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();


        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("List after adding elements: " + list);


        list.add(1, 5);
        System.out.println("List after inserting at position 1: " + list);


        System.out.println("Element at position 2: " + list.get(2));


        list.remove(5);
        System.out.println("List after removing element 5: " + list);


        list.remove(1);
        System.out.println("List after removing element at position 1: " + list);


        list.add(1);
        list.add(1);
        list.removeAll(1);
        System.out.println("List after removing all occurrences of 1: " + list);

        list.addFirst(7);
        System.out.println("List after adding element 7 at the beginning: " + list);


        System.out.println("Size of the list: " + list.getSize());


        System.out.print("List elements: ");
        for (Integer element : list) {
            System.out.print(element + " ");
        }

    }
}