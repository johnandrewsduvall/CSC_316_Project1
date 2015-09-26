/*
 * Author:     John Andrew S Duvall, Matthew Watkins, ShuJun Ye
 * Date:       27 Sep 2015
 * Project:    CSC 316 Project1
 */
package csc_316_project1;

import java.util.Scanner;

/**
 * The starting entry point of the program
 * @author Matthew Watkins
 * @version 1.0
*/
public class Receiver {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        MessageProcessor processor = new MessageProcessor();
        Scanner scanner = new Scanner(System.in);

        // Iterate over each line and parse it
        while (scanner.hasNextLine()) {
            PacketInfo packetInfo = PacketInfo.parse(scanner.nextLine());
            if (packetInfo != null) {
                // Valid packet info-- process it
                processor.add(packetInfo);
            }
        }

        // Output
        Node<Message> msgNode = processor.messages.head;
        MessagePrinter.printMessage(msgNode.id, msgNode.value, false);
        while (msgNode.hasNext()) {
            msgNode = msgNode.next;
            MessagePrinter.printMessage(msgNode.id, msgNode.value, true);
        }
    }
}
