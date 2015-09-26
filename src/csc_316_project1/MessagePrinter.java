/*
 * Author:     John Andrew S Duvall, Matthew Watkins, ShuJun Ye
 * Date:       27 Sep 2015
 * Project:    CSC 316 Project1
 */
package csc_316_project1;

/**
 * A static class that prints messages
 * @author Matthew Watkins
 * @version 1.0
*/
public class MessagePrinter {
    /**
    * Prints a message
    * @param messageID the ID of the message to print
    * @param message the message to print
    * @param prependEmptyLine whether or not to prepend the message
    * with an empty line
    */
    public static void printMessage(long messageID, Message message,
                                                     boolean prependEmptyLine) {
        if (prependEmptyLine) {
            System.out.println();
        }
        System.out.println("--- Message " + messageID);
        printPackets(messageID, message.packets);
        System.out.println("--- End Message " + messageID);
    }

    /**
    * Prints a collection of packets
    * @param messageID the ID of the packets to print
    * @param packets the packets to print
    */
    private static void printPackets(long messageID,
                                             SortedLinkedList<Packet> packets) {
        long previousPacketID = 0;
        Node<Packet> packetNode = packets.head;
        printPacket(messageID, previousPacketID, packetNode.id,
                                                              packetNode.value);
        previousPacketID = packetNode.id;
        while (packetNode.hasNext()) {
            packetNode = packetNode.next;
            printPacket(messageID, previousPacketID, packetNode.id,
                                                              packetNode.value);
            previousPacketID = packetNode.id;
        }
    }

    /**
    * Prints a packet
    * @param messageID the message ID of the packet to print
    * @param previousPacketID the packet ID of the previously printed packet
    * @param thisPacketID the packet ID of the packet to print
    * @param packet the packet to print
    */
    private static void printPacket(long messageID, long previousPacketID,
                                             long thisPacketID, Packet packet) {
        long missingPackets = thisPacketID - (previousPacketID + 1);
        if (missingPackets > 0) {
            // Log missing packets
            for (long i = 1; i <= missingPackets; i++) {
                System.out.println("WARNING: packet " + (previousPacketID + i)
                                  + " of message " + messageID + " is missing");
            }
        }
        System.out.println(packet.text);
    }
}