class MyLinkedList {

    class Node{
        int val;
        Node next;
        Node prev;

        Node(int val){
            this.val = val;
            this.next = null;
            this.prev= null;
        }
    }

    private Node head;
    private Node tail;
    int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    public int get(int index) {
        if(index <0 || index >= size ){
            return -1;
        }

        Node current = head;

        for (int i=0 ; i<index ;i++){
            current = current.next;
        }

        return current.val;        
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);

        if (head == null){
            head= newNode;
            tail = newNode;
        }
        else{
             newNode.next= head;
             head.prev= newNode;
             head = newNode;
        }

        size ++;
        
    }
    
    public void addAtTail(int val) {

        Node newNode = new Node(val);
        if(tail == null){
            head= newNode; 
            tail = newNode;
        } else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }
    
    public void addAtIndex(int index, int val) {

        if(index < 0 || index >size ){
            return;
        }

        if( index == 0){
            addAtHead(val);
            return;
        }

        if ( index == size){
            addAtTail(val);
            return;
        }

        Node newNode = new Node(val);

        Node current = head;

        for(int i =0; i < index-1; i++){
            current = current.next; 
        }

        newNode.next = current.next;
        current.next.prev = newNode;
        current.next = newNode;
        newNode.prev= current;

        size++;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {

            head = head.next;
            size--;

            if (size == 0) {
                tail = null;
            } else {
                head.prev = null;
            }

            return;
        }

         if (index == size - 1) {

            tail = tail.prev;
            tail.next = null;
            size--;

            return;
        }

        Node current = head;

       for ( int i =0 ; i < index-1; i++){
        current = current.next;
       }
        Node nodeToDelete = current.next;
        current.next = nodeToDelete.next;
        nodeToDelete.next.prev = current;

        size--;

    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */