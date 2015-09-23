/*
 * Author:     John Andrew S Duvall, [put names here]
 * Date:       27 Sep 2015
 * Project:    CSC 316 Project1
 */
package csc_316_project1;

public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        MessageProcessor processor = new MessageProcessor();
        // while Scanner has next line
            // process next line

        // Test processor code
        processor.add(3, 2, "morning");
        processor.add(17, 1, "See");
        processor.add(10, 3, "you");
        processor.add(17, 2, "forget");
        processor.add(10, 1, "How");
        processor.add(17, 3, "later");
        processor.add(3, 1, "Good");
        processor.add(17, 2, "you");
        processor.add(10, 4, "doing");

        // Output
        printMessages(processor.messages);
    }

    private static void processLine(MessageProcessor processor, String line) throws Exception {
        long messageID = extractMessageID(line);
        long packetID = extractPacketID(line);
        String text = extractText(line);
        processor.add(messageID, packetID, text);
    }

    private static long extractMessageID(String line) {
        // TODO: do stuff
        return -1;
    }

    private static long extractPacketID(String line) {
        // TODO: do stuff
        return -1;
    }

    private static String extractText(String line) {
        // TODO: do stuff
        return null;
    }

    private static void printMessages(CustomLinkedList<Message> messages) {
        CustomNode<Message> messageNode = messages.head;
        printMessage(messageNode.id, messageNode.value);
        while (messageNode.hasNext()) {
            messageNode = messageNode.next;
            printMessage(messageNode.id, messageNode.value);
        }
    }

    private static void printMessage(long messageID, Message message) {
        System.out.println();
        System.out.println("--- Message " + messageID);
        printPackets(message.packets);
        System.out.println("--- End Message " + messageID);
    }

    private static void printPackets(CustomLinkedList<Packet> packets) {
        CustomNode<Packet> packetNode = packets.head;
        printPacket(packetNode.value);
        while (packetNode.hasNext()) {
            packetNode = packetNode.next;
            printPacket(packetNode.value);
        }
    }

    private static void printPacket(Packet packet) {
        System.out.println(packet.text);
    }
}
