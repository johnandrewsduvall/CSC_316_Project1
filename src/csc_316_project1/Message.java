/**
 * Author:     John Andrew S Duvall, Matthew Watkins, ShuJun Ye
 * Date:       27 Sep 2015
 * Project:    CSC 316 Project1
 */
package csc_316_project1;

/**
 * Represents a message containing packets
 * @author Matthew Watkins
 * @version 1.0
*/
public class Message {
    /**
    * The packets of the message
    */
    public SortedLinkedList<Packet> packets;

    /**
    * Constructor for the Message object
    */
    public Message() {
        this.packets = new SortedLinkedList<Packet>();
    }
}