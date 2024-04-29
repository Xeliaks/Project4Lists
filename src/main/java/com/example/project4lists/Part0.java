package com.example.project4lists;

import java.util.ArrayList;
import java.util.LinkedList;

public class Part0 {
    public static void main(String[] args) {
        int numElements = 100000;

        // ArrayList
        ArrayList<Integer> arrayList = new ArrayList<>();
        long startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            arrayList.add(0, i);
        }
        long arrayListInsertionTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            arrayList.get(i);
        }
        long arrayListAccessTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            arrayList.remove(0);
        }
        long arrayListRemovalTime = System.nanoTime() - startTime;

        // LinkedList
        LinkedList<Integer> linkedList = new LinkedList<>();
        startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            linkedList.add(0, i);
        }
        long linkedListInsertionTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            linkedList.get(i);
        }
        long linkedListAccessTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            linkedList.remove(0);
        }
        long linkedListRemovalTime = System.nanoTime() - startTime;


        System.out.println("ArrayList Insertion Time: " + arrayListInsertionTime + " ns");
        System.out.println("ArrayList Access Time: " + arrayListAccessTime + " ns");
        System.out.println("ArrayList Removal Time: " + arrayListRemovalTime + " ns");

        System.out.println("LinkedList Insertion Time: " + linkedListInsertionTime + " ns");
        System.out.println("LinkedList Access Time: " + linkedListAccessTime + " ns");
        System.out.println("LinkedList Removal Time: " + linkedListRemovalTime + " ns");
    }
}