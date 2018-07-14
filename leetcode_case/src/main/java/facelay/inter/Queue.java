package facelay.inter;

public interface Queue<E> {
    int size();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue() throws IllegalAccessException;

    E getFront() throws IllegalAccessException;

}
