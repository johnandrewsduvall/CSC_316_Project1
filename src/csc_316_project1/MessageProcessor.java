package csc_316_project1;

public class MessageProcessor {
    public SortedLinkedList<Message> messages;

    public MessageProcessor() {
        this.messages = new SortedLinkedList<Message>();
    }

    public void add(long messageID, long packetID, String text) throws Exception {
        Node<Message> messageNode = this.messages.getOrCreateNode(messageID, false, new Message());
        messageNode.value.packets.getOrCreateNode(packetID, true, new Packet(text));
    }
}