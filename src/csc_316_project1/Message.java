package csc_316_project1;

public class Message {
    public CustomLinkedList<Packet> packets;

    public Message() {
        this.packets = new CustomLinkedList<Packet>();
    }
}