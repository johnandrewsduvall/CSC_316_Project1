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
                // This node belongs between current node and next (handles tails)
                newNodeDefault.next = currentNode.next;
                currentNode.next = newNodeDefault;
                break;
            }
            currentNode = currentNode.next;
        }

        return newNodeDefault;
    }

    public void insertNode(Node node) {
        // Head replacement
        if (this.head == null || this.head.id > node.id) {
            node.next = head;
            this.head = node;
            return;
        }

        // Traverse the rest of the list
        Node currentNode = this.head;
        while (currentNode != null) {
            if (currentNode.id == node.id) {
                // Replace the current node
                System.out.println("Replacing node value " + node.id);
                node.next = currentNode.next;
                currentNode = node;
                return;
            }
            else if (currentNode.next == null || currentNode.next.id > node.id) {
                // This node belongs between current node and next (handles tails)
                node.next = currentNode.next;
                currentNode.next = node;
                return;
            }

            currentNode = currentNode.next;
        }
    }
}