package csc_316_project1;

public class MessageNode extends Node {
    public CustomLinkedList packetList;

    public MessageNode(int id) {
        super(id);
        packetList = new CustomLinkedList();
    }
}