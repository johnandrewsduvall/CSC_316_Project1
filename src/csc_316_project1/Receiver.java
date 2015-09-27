/*
 * Author:     John Andrew S Duvall, Matthew Watkins, ShuJun Ye
 * Date:       27 Sep 2015
 * Project:    CSC 316 Project1
 */
package csc_316_project1;

import java.util.Scanner;
import java.io.*;


/**
 * A class to receive and print packets
 * @author Matthew Watkins
 * @version 1.0
*/
public class Receiver {
    /**
     * The starting entry point of the program
     * @param args the command line arguments.
     * Arg0 = input file path,
     * Arg1 = output file path
     * @throws java.io.FileNotFoundException
    */
    public static void main(String[] args) throws Exception,
                                                         FileNotFoundException {
                     // Parse the input file
                     MessageProcessor processor = parseFile(args[0]);
                     // Write to the output file
                     print(args[1], processor);
    }
    /**
     * Reads the specified file and returns a parsed object of the data
     * @param inputFilePath the path of the input file to parse
    */
    private static MessageProcessor parseFile(String inputFilePath)
                                       throws Exception, FileNotFoundException {
        // Create the processor
        MessageProcessor processor = new MessageProcessor();

        // Initialize the scanner
        Scanner scanner = new Scanner(new File(inputFilePath));

        // Iterate over each line
        while (scanner.hasNextLine()) {
            // Parse the line
            PacketInfo packetInfo = PacketInfo.parse(scanner.nextLine());
            if (packetInfo != null) {
                // Valid packet info-- process it
                processor.add(packetInfo);
            }
        }
        // Return the complete processor
        return processor;
    }

    /**
     * Prints the packet messages to the specified file path
     * @param outputPath the path of the output file to write to
     * processor the object containing the messages to write
    */
    private static void print(String outputPath, MessageProcessor processor)
                                                  throws FileNotFoundException {
        // Creates a stream to write to
        PrintStream outputFile = new PrintStream(new File(outputPath));

        // Start with the head message node  of the processor
        Node<Message> msgNode = processor.messages.head;

        // print the message to the output stream
        MessagePrinter.printMessage(outputFile, msgNode.id,
                                                          msgNode.value, false);
        // Iterate over each successive message nomde
        while (msgNode.hasNext()) {
            msgNode = msgNode.next;
            // Print the message
            MessagePrinter.printMessage(outputFile, msgNode.id,
                                                           msgNode.value, true);
        }
    }
}