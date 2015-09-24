/*
 * Author:     John Andrew S Duvall, Matthew Watkins, ShuJun Ye
 * Date:       27 Sep 2015
 * Project:    CSC 316 Project1
 */
package csc_316_project1;

/**
 * A class for parsing and storing packet information
 * @author Matthew Watkins
 * @version 1.0
*/
public class PacketInfo {
    public long messageID;
    public long packetID;
    public String text;

    /**
    * Constructor for the PacketInfo object
    * @param text the text value of the node
    */
    public PacketInfo(long messageID, long packetID, String text) {
        this.messageID = messageID;
        this.packetID = packetID;
        this.text = text;
    }

    /**
    * Parses packet info from a given line of text
    * in format "{msgID} {pktID} {text}"
    * @param line the line of text to parse
    */
    public static PacketInfo parse(String line) {
        String trimmed = line.trim();
        if (trimmed.length() < 4) {
            return null;
        }

        StringBuilder msgID = new StringBuilder();
        StringBuilder pktID = new StringBuilder();
        StringBuilder pktText = new StringBuilder();

        boolean parsingMessageID = true;
        boolean parsingPacketID = false;
        boolean parsingPacketText = false;

        for (char c : trimmed.toCharArray()) {
            if (parsingMessageID) {
                if (Character.isDigit(c)) {
                    msgID.append(c);
                } else if (msgID.length() > 0 && Character.isWhitespace(c)) {
                    parsingMessageID = false;
                    parsingPacketID = true;
                }
            } else if (parsingPacketID) {
                if (Character.isDigit(c)) {
                    pktID.append(c);
                } else if (pktID.length() > 0 && Character.isWhitespace(c)) {
                    parsingPacketID = false;
                    parsingPacketText = true;
                }
            } else if (parsingPacketText) {
                pktText.append(c);
            }
        }

        long messageID = Long.parseLong(msgID.toString());
        long packetID = Long.parseLong(pktID.toString());

        return new PacketInfo(messageID, packetID, pktText.toString());
    }
}