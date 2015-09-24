/**
 * Author:     John Andrew S Duvall, Matthew Watkins, ShuJun Ye
 * Date:       27 Sep 2015
 * Project:    CSC 316 Project1
 */
package csc_316_project1;

/**
 * A custom-rolled generic class for storing nodes
 * @author Matthew Watkins
 * @version 1.0
*/
public class Node<E> {
    /**
    * Identifier of the node
    */
    public long id;

    /**
    * Value of the node
    */
    public E value;

    /**
    * Pointer to the node's predecessor node
    */
    public Node<E> previous;

    /**
    * Pointer to the node's successor node
    */
    public Node<E> next;

    /**
    * Constructor for the Node object
    * @param id the identifier of the node
    * @param value the value of the node
    */
    public Node(long id, E value) {
        this.id = id;
        this.value = value;
    }

    /**
    * Specifies whether the node has a successor
    * @return whether the node has a successor
    */
    public boolean hasNext() {
        return this.next != null;
    }

    /**
    * Specifies whether the node has a predecessor
    * @return whether the node has a predecessor
    */
    public boolean hasPrevious() {
        return this.previous != null;
    }
}