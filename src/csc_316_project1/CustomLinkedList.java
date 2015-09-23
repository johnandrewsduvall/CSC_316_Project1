package csc_316_project1;

public class CustomLinkedList<E> {
    public CustomNode<E> head;

    public CustomLinkedList() {

    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public CustomNode<E> getOrCreateNode(long nodeID, boolean updateValue, E value) throws Exception {
        CustomNode<E> newNode = new CustomNode<E>(nodeID, value);

        // Check to see if it becomes the new head
        if (isEmpty()) {
            this.head = newNode;
            return newNode;
        }

        // Traverse through the list to find its place
        CustomNode<E> currentNode = this.head;
        while (currentNode != null) {
            // Handle matching node ID
            if (currentNode.id == nodeID) {
                if (updateValue) {
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

        // If we've gotten this far, there is a major bug since the tail conditionvshould be handled in the loop
        throw new Exception("Null currentNode. This indicates a a=serious bug");
    }

    private void insertBefore(CustomNode<E> thisNode, CustomNode<E> nextNode) {
        if (nextNode.hasPrevious()) {
            // Alert the neighbor
            nextNode.previous.next = thisNode;
        }
        nextNode.previous = thisNode;
        thisNode.next = nextNode;
    }

    private void insertAfter(CustomNode<E> thisNode, CustomNode<E> previousNode) {
        if (previousNode.hasNext()) {
            // Alert the neighbor
            previousNode.next.previous = thisNode;
        }
        previousNode.next = thisNode;
        thisNode.previous = previousNode;
    }
}