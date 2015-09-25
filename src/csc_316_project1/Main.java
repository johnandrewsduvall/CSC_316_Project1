/*
 * Author:     John Andrew S Duvall, Matthew Watkins, ShuJun Ye
 * Date:       27 Sep 2015
 * Project:    CSC 316 Project1
 */
package csc_316_project1;

import java.util.Scanner;

public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // process input lines
        MessageProcessor processor = new MessageProcessor();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            PacketInfo packetInfo = PacketInfo.parse(scanner.nextLine());
            if (packetInfo != null) {
                // Valid packet info
                processor.add(packetInfo);
            }
        }

        // Output
        printMessages(processor.messages);
    }

    private static void printMessages(SortedLinkedList<Message> messages) {
        Node<Message> messageNode = messages.head;
        printMessage(messageNode.id, messageNode.value, false);
        boolean isFirst = true;
        while (messageNode.hasNext()) {
            messageNode = messageNode.next;
            printMessage(messageNode.id, messageNode.value, true);
            isFirst = false;
        }
    }

    private static void printMessage(long messageID, Message message,
                                                     boolean prependEmptyLine) {
        if (prependEmptyLine) {
            System.out.println();
        }
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
