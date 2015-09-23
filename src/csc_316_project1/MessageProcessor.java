package csc_316_project1;

public class MessageProcessor {
    public CustomLinkedList<Message> messages;

    public MessageProcessor() {
        this.messages = new CustomLinkedList<Message>();
    }

    public void add(long messageID, long packetID, String text) throws Exception {
        CustomNode<Message> messageNode = this.messages.getOrCreateNode(messageID, true, new Message());
        Message msg = messageNode.value;
        CustomLinkedList<Packet> packets = msg.packets;
        packets.getOrCreateNode(packetID, true, new Packet(text));
    }
}