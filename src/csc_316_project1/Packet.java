/**
 * Author:     John Andrew S Duvall, Matthew Watkins, ShuJun Ye
 * Date:       27 Sep 2015
 * Project:    CSC 316 Project1
 */
package csc_316_project1;

/**
 * Represents a packet containing a text string
 * @author Matthew Watkins
 * @version 1.0
*/
public class Packet {
    /**
    * The text value of the node
    */
    public String text;

    /**
    * Constructor for the Packet object
    * @param text the text value of the node
    */
    public Packet(String text) {
        this.text = text;
    }
}