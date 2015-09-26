/*
 * Author:     John Andrew S Duvall, Matthew Watkins, ShuJun Ye
 * Date:       27 Sep 2015
 * Project:    CSC 316 Project1
 */
package csc_316_project1;

import java.io.*;

/**
 * A static class that prints messages
 * @author Matthew Watkins
 * @version 1.0
*/
public class MessagePrinter {
    /**
    * Prints a message
    * @param printer the print stream to write to
    * @param messageID the ID of the message to print
    * @param message the message to print
    * @param prependEmptyLine whether or not to prepend the message
    * with an empty line
    */
    public static void printMessage(PrintStream printer, long messageID,
                                    Message message, boolean prependEmptyLine) {
        if (prependEmptyLine) {
            printer.println();
        }
        printer.println("--- Message " + messageID);
        printPackets(printer, messageID, message.packets);
        printer.println("--- End Message " + messageID);
    }

    /**
    * Prints a collection of packets
    * @param printer the print stream to write to
    * @param messageID the ID of the packets to print
    * @param packets the packets to print
    */
    private static void printPackets(PrintStream printer, long messageID,
                                             SortedLinkedList<Packet> packets) {
        long previousPacketID = 0;
        Node<Packet> packetNode = packets.head;
        printPacket(printer, messageID, previousPacketID, packetNode.id,
                                                              packetNode.value);
        previousPacketID = packetNode.id;
        while (packetNode.hasNext()) {
            packetNode = packetNode.next;
            printPacket(printer, messageID, previousPacketID,
                                               packetNode.id, packetNode.value);
            previousPacketID = packetNode.id;
        }
    }

    /**
    * Prints a packet
    * @param printer the print stream to write to
    * @param messageID the message ID of the packet to print
    * @param previousPacketID the packet ID of the previously printed packet
    * @param thisPacketID the packet ID of the packet to print
    * @param packet the packet to print
    */
    private static void printPacket(PrintStream printer, long messageID,
                      long previousPacketID, long thisPacketID, Packet packet) {
        long missingPackets = thisPacketID - (previousPacketID + 1);
        if (missingPackets > 0) {
            // Log missing packets
            for (long i = 1; i <= missingPackets; i++) {
                printer.println("WARNING: packet " + (previousPacketID + i)
                                  + " of message " + messageID + " is missing");
            }
        }
        printer.println(packet.text);
    }
}