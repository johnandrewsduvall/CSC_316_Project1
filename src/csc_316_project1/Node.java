package csc_316_project1;

public class Node<E> {
    public long id;
    public E value;
    public Node<E> previous = null;
    public Node<E> next = null;

    public Node(long id, E value) {
        this.id = id;
        this.value = value;
    }

    public boolean hasNext() {
        return this.next != null;
    }

    public boolean hasPrevious() {
        return this.previous != null;
    }
}