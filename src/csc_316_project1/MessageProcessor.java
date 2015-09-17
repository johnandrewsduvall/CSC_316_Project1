package csc_316_project1;

public class MessageProcessor {
    public CustomLinkedList messageList;

    public MessageProcessor() {
        messageList = new CustomLinkedList();
    }

    public void add(int messageID, int packetID, String value) {
        MessageNode messageNode = (MessageNode)(messageList.getOrCreateNode(messageID, new MessageNode(messageID)));
        messageNode.packetList.insertNode(new PacketNode(packetID, value));
    }
}