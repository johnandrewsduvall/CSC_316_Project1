package csc_316_project1;

public class Message {
    public SortedLinkedList<Packet> packets;

    public Message() {
        this.packets = new SortedLinkedList<Packet>();
    }
}