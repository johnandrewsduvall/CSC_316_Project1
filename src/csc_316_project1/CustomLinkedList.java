package csc_316_project1;

public class CustomLinkedList {
    public Node head;

    public Node getOrCreateNode(int nodeID, Node newNodeDefault) {
        // Handle empty list
        if (this.head == null) {
            this.head = newNodeDefault;
            return newNodeDefault;
        }

        // Traverse the list
        Node currentNode = this.head;
        while (currentNode != null) {
            if (nodeID == currentNode.id) {
                return currentNode;
            } else if (currentNode.next == null || currentNode.next.id > nodeID) {
                // It should belong after this node but doesn't exist yet.
                // Insert it here (this handles tails)
                newNodeDefault.next = currentNode.next;
                currentNode.next = newNodeDefault;
                break;
            }
        }

        return newNodeDefault;
    }

    public void insertNode(Node node) {
        // Handle empty list
        if (this.head == null) {
            this.head = node;
            return;
        }

        // Handle head replacement
        if (this.head.id > node.id) {
            node.next = this.head;
            this.head = node;
            return;
        }

        // Traverse the list until we find its place
        Node currentNode = this.head;
        while (currentNode.next != null) {
            if (currentNode.id == node.id) {
                // Replace the current node
                node.next = currentNode.next;
                currentNode = node;
                return;
            }
            if (currentNode.next.id < node.id || currentNode.next == null) {
                // Place the node between current and next
                // Note: this will handle tails as well
                node.next = currentNode.next;
                currentNode.next = node;
                return;
            }

            currentNode = currentNode.next;
        }
    }
}