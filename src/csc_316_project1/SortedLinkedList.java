/*
 * Author:     John Andrew S Duvall, Matthew Watkins, ShuJun Ye
 * Date:       27 Sep 2015
 * Project:    CSC 316 Project1
 */
package csc_316_project1;

/**
 * A -rolled ADT for storing sorted linked lists
 * @author Matthew Watkins
 * @version 1.0
*/
public class SortedLinkedList<E>
{
    /**
    * Head of the linked list
    */
    public Node<E> head;

    /**
    * Specifies whether the list is empty
    * @return whether the list is empty
    */
    public boolean isEmpty()
    {
        return this.head == null;
    }

    /**
    * Gets the node with the specified node ID. If the node doesn't exist,
    * it is created in the proper place using the value provided.
    * If updateValue is true and the node ID already exists, the node's value
    * will be replaced with the value passed in.
    * @param nodeID the node ID to search for or create
    * @param updateValue whether or not to replace the value of the node if
    *    the node exists
    * @param value the value to create or set if the node doesn not exist or
    *    should be updated
    * @return the node found or affected
    */
    public Node<E> getOrCreateNode(long nodeID, boolean updateValue,
                                                E value) throws Exception
    {
        // Create a default node (in case we need to create)
        Node<E> newNode = new Node<E>(nodeID, value);

        // Check to see if it should become the head
        if (isEmpty())
        {
            this.head = newNode;
            return newNode;
        }

        // Traverse through the list to find its place
        Node<E> currentNode = this.head;
        while (currentNode != null)
        {
            // Handle matching node ID
            if (currentNode.id == nodeID)
            {
                if (updateValue)
                {
                    // Replace the node's value with the value passed in
                    currentNode.value = value;
                }
                return currentNode;
            }

            // See if we've found our spot in line
            if (currentNode.id > nodeID) {
                insertBefore(newNode, currentNode);
                return newNode;
            }

            // Handle tail condition
            if (!currentNode.hasNext()) {
                insertAfter(newNode, currentNode);
                return newNode;
            }

            // No dice, check the next guy
            currentNode = currentNode.next;
        }

        // If we've gotten this far, there is a major bug since the tail condition
        // should be handled in the loop
        throw new Exception("Null currentNode. This indicates a a=serious bug");
    }

    private void insertBefore(Node<E> newNode, Node<E> refNode) {
        if (refNode.hasPrevious()) {
            // Point the "next node" pointer of the reference node's predecessor
            // to the new node
            refNode.previous.next = newNode;

            // Copy the reference node's "previous node" pointer
            // to the new node's "previous node" pointer
            newNode.previous = refNode.previous;
        } else {
            // The ref node is the head
            this.head = newNode;
        }

        // Point the reference node's "previous node" pointer
        // to the new node
        refNode.previous = newNode;

        // Point the new node's "next node" pointer
        // to the reference node
        newNode.next = refNode;
    }

    private void insertAfter(Node<E> newNode, Node<E> refNode) {
        if (refNode.hasNext()) {
            // Point the "previous node" pointer of the reference node's successor
            // to the new node
            refNode.next.previous = newNode;
        }

        // Copy the reference node's "next node" pointer
        // to the new node's "next node" pointer
        newNode.next = refNode.next;

        // Point the reference node's "next node" pointer
        // to the new node
        refNode.next = newNode;

        // Point the new node's "previous node" pointer
        // to the reference node
        newNode.previous = refNode;
    }
}