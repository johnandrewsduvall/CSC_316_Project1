/*
 * Author:     John Andrew S Duvall, Matthew Watkins, ShuJun Ye
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

        // Test processor code.
        // Delete when we have proper tests
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

    private static void printMessages(SortedLinkedList<Message> messages) {
        Node<Message> messageNode = messages.head;
        printMessage(messageNode.id, messageNode.value);
        while (messageNode.hasNext()) {
            messageNode = messageNode.next;
            printMessage(messageNode.id, messageNode.value);
        }
    }

    private static void printMessage(long messageID, Message message) {
        System.out.println();
        System.out.println("--- Message " + messageID);
        printPackets(messageID, message.packets);
        System.out.println("--- End Message " + messageID);
    }

    private static void printPackets(long messageID, SortedLinkedList<Packet> packets) {
        long previousPacketID = 0;
        Node<Packet> packetNode = packets.head;
        printPacket(messageID, previousPacketID, packetNode.id, packetNode.value);
        previousPacketID = packetNode.id;

        while (packetNode.hasNext()) {
            packetNode = packetNode.next;
            printPacket(messageID, previousPacketID, packetNode.id, packetNode.value);
            previousPacketID = packetNode.id;
        }
    }

    private static void printPacket(long messageID, long previousPacketID, long thisPacketID, Packet packet) {
        long missingPackets = thisPacketID - (previousPacketID + 1);
        if (missingPackets > 0) {
            // Log missing packets
            for (long i = 1; i <= missingPackets; i++) {
                System.out.println("WARNING: packet " + (previousPacketID + i) + " of message " + messageID + " is missing");
            }
        }
        System.out.println(packet.text);
    }
}
