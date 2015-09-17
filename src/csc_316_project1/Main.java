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
        for(String line : breakIntoLines(args[0])) {
            int messageID = extractMessageID(line);
            int packetID = extractPacketID(line);
            String value = extractMessage(line);
            processor.add(messageID, packetID, value);
        }
    }

    private static String[] breakIntoLines(String text) {
        // TODO: do stuff
        return null;
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
