/*
 * Author:     John Andrew S Duvall, Matthew Watkins, ShuJun Ye
 * Date:       27 Sep 2015
 * Project:    CSC 316 Project1
 */
package csc_316_project1;

import java.util.Scanner;

/**
 * A class for parsing and storing packet information
 * @author Matthew Watkins
 * @version 1.0
*/
public class PacketInfo {
    /**
    * Message ID of the packet
    */
    public long messageID;

    /**
    * Packet ID of the packet
    */
    public long packetID;

    /**
    * Text value of the packet
    */
    public String text;

    /**
    * Constructor for the PacketInfo object
    * @param text the text value of the node
    */
    public PacketInfo(long messageID, long packetID, String text) {
        this.messageID = messageID;
        this.packetID = packetID;
        this.text = text.trim();
    }

    /**
    * Parses packet info from a given line of text
    * in format "{msgID} {pktID} {text}"
    * @param line the line of text to parse
    */
    public static PacketInfo parse(String line) {
        // Trim the line. Return null if nothing to parse
        String trimmed = line.trim();
        if (trimmed.length() < 4) {
            return null;
        }

        // Create the PacketInfo object
        Scanner scanner = new Scanner(line);
        return new PacketInfo(scanner.nextLong(), scanner.nextLong(),
                                                            scanner.nextLine());
    }
}