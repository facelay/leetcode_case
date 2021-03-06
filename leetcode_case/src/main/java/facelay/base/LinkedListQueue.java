package facelay.base;


import facelay.inter.Queue;

public class LinkedListQueue<E> implements Queue {

    private E e;

    private class Node {

        public Node next;
        private E e;

        public Node(Node next, E e) {
            this.next = next;
            this.e = e;
        }

        public Node(E e) {
            this.e = e;
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(Object e) {
        if (tail == null) {
            tail = new Node((E) e);
            head = tail;
        } else {
            tail.next = new Node((E) e);
            tail = tail.next;

        }
        size++;
    }

    @Override
    public Object dequeue() throws IllegalAccessException {
        if (isEmpty()) {
            throw new IllegalAccessException("Cannot dequeue from an queue.");
        } else {
            Node retNode = head;
            head = head.next;
            retNode.next = null;
            if (head == null) {
                tail = null;
            }
            size--;
            return retNode.e;
        }
    }

    @Override
    public Object getFront() throws IllegalAccessException {
        if (isEmpty()) {
            throw new IllegalAccessException("Cannot dequeue from an queue.");
        }
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: Front ");
        Node cur = this.head;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }

    public static void main(String[] args) throws IllegalAccessException {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }

        }
    }
}