package csc_316_project1;

public class CustomNode<E> {
    public long id;
    public E value;
    public CustomNode<E> previous = null;
    public CustomNode<E> next = null;

    public CustomNode(long id, E value) {
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