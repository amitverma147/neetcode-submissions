class MyLinkedList {

    private class Node {
        int val;
        Node next;
        Node prev;

        Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Get node at index
    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        // Start from the closer side
        if (index < size / 2) {
            Node current = head;

            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            return current;
        } else {
            Node current = tail;

            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }

            return current;
        }
    }

    public int get(int index) {
        Node node = getNode(index);
        return node == null ? -1 : node.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);

        if (size == 0) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        size++;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);

        if (size == 0) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }

        if (index == 0) {
            addAtHead(val);
            return;
        }

        if (index == size) {
            addAtTail(val);
            return;
        }

        // Find node currently at index
        Node current = getNode(index);

        Node newNode = new Node(val);

        newNode.prev = current.prev;
        newNode.next = current;

        current.prev.next = newNode;
        current.prev = newNode;

        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        Node nodeToDelete = getNode(index);

        if (nodeToDelete.prev != null) {
            nodeToDelete.prev.next = nodeToDelete.next;
        } else {
            head = nodeToDelete.next;
        }

        if (nodeToDelete.next != null) {
            nodeToDelete.next.prev = nodeToDelete.prev;
        } else {
            tail = nodeToDelete.prev;
        }

        size--;
    }
}