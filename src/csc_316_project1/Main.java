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
    public static void main(String[] args) {
        MessageProcessor processor = new MessageProcessor();
        // while Scanner has next line
            // process next line

        // Test processor code
        processor.add(3, 2, "morning");
        processor.add(17, 10, "See");
        processor.add(10, 3, "you");
        processor.add(17, 2, "forget");
        processor.add(10, 1, "How");
        processor.add(17, 3, "later");
        processor.add(3, 1, "Good");
        processor.add(17, 2, "you");
        processor.add(10, 4, "doing");

        // Output
        MessageNode messageNode = (MessageNode)(processor.messageList.head);
        while (messageNode != null) {
            System.out.println("Message " + messageNode.id);
            PacketNode packetNode = (PacketNode)(messageNode.packetList.head);
            while (packetNode != null) {
                System.out.println("Packet " + packetNode.id + ": " + packetNode.value);
                packetNode = (PacketNode)packetNode.next;
                System.out.print("-");
            }
            messageNode = (MessageNode)(messageNode.next);
            
        }
        System.out.println("done");
    }

    private static void processLine(MessageProcessor processor, String line) {
        int messageID = extractMessageID(line);
        int packetID = extractPacketID(line);
        String value = extractMessage(line);
        processor.add(messageID, packetID, value);
    }

    private static int extractMessageID(String line) {
        // TODO: do stuff
        return -1;
    }

    private static int extractPacketID(String line) {
        // TODO: do stuff
        return -1;
    }

    private static String extractMessage(String line) {
        // TODO: do stuff
        return null;
    }
}
