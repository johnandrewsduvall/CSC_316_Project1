/**
 * Author:     John Andrew S Duvall, Matthew Watkins, ShuJun Ye
 * Date:       27 Sep 2015
 * Project:    CSC 316 Project1
 */
package csc_316_project1;

/**
 * A class that processes incoming packet information by message ID
 * @author Matthew Watkins
 * @version 1.0
*/
public class MessageProcessor {
    /**
    * The messages created so far by the input
    */
    public SortedLinkedList<Message> messages;

    /**
    * Constructor for the MessageProcessor object by initializing
    * the messages linked list property
    */
    public MessageProcessor() {
        this.messages = new SortedLinkedList<Message>();
    }

    /**
    * Adds packet information and inserts it into the proper message and packets
    */
    public void add(long messageID, long packetID, String text)
                                                    throws Exception {
        Node<Message> messageNode = this.messages.getOrCreateNode(messageID,
                                                          false, new Message());
        messageNode.value.packets.getOrCreateNode(packetID,
                                                        true, new Packet(text));
    }
}