package csc_316_project1;

public abstract class Node {
    public int id;
    public Node next;

    protected Node(int id) {
        this.id = id;
    }
}