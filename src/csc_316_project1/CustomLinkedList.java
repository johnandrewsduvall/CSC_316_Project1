package project1.teamdragon.csc316;

public class CustomLinkedList {
    public Node head;

    public void insertNode(Node node) {
        // Check for head replacement
        if (this.head.id > node.id) {
            node.next = this.head;
            this.head = node;
            return;
        }

        // Traverse the list until we find its place
        Node current = this.head;
        while (current.next != null) {
            if (current.id == node.id) {
                // Replace the current node
                node.next = current.next;
                current = node;
                return;
            }
            if (current.next.id < node.id || current.next == null) {
                // Place the node between current and next
                // Note: this will handle tails as well
                node.next = current.next;
                current.next = node;
                return;
            }
        }
    }
}