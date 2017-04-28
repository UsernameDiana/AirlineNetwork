/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportGraphs_Queues;

import java.util.NoSuchElementException;

/**
 *
 * @author diana
 */
public class LinkedQueue<T> implements IQueue<T> {

    private class Node {

        T data;
        Node next;

        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head = null;
    private Node tail = null;

    @Override
    public void enqueue(T item) {
        Node node = new Node(item, null);
        if (isEmpty()) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T item = head.data;
        if (tail == head) {
            tail = null;
        }
        head = head.next;
        return item;
    }

    @Override
    public T peek() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        int size = 0;
        for (Node n = head; n != null; n = n.next) {
            size++;
        }
        return size;
    }

}
