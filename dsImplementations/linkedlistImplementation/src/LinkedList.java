public class LinkedList {
    Node head; // refers to first node
    int length = 1;

    // Insert node with input data at end of Linked List
    public Node append(int data) {

        // Create new node with given data
        Node newNode = new Node(data);

        // Check if first node or not, if empty then new node is head
        if (head == null)
        {
            head = newNode;
            newNode.prev = null;
            return head;

        }
        else {
            // Traverse to last node then append the new node to the end
            // Temp node refers to head node, then checks the next
            // nodes until it hits last
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode; // append newNode to end of list
            newNode.prev = temp; // newNode prev pointer set to node before
        }
        length++;
        return head;
    }

    // Insert node with input data at start of Linked List
    public Node prepend(int data) {

        Node newNode = new Node(data);


        // Let the new Node point to the head and new node point to null
        newNode.next = head;
        newNode.prev = null;

        // current head prev pointer points to new head
        if (head != null) {
            head.prev = newNode;
        }

        // make newNode the head
        head = newNode;

        length++;
        return head;

    }

    // Insert node at position

    public Node insert(int index, int data){

        Node newNode = new Node(data);

        // Edge case checks
        if (index <= 0) {
            prepend(data);
        }
        else if (index >= length) {
            append(data);
        }
        else {
            Node temp = head;
            // Traverse to index where node is to be inserted
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }

            // new node now points to the next node that temp node traversed
            newNode.next = temp.next;
            // insert new node after traversed temp node
            temp.next = newNode;

            // newNode prev pointer points to traversed temp
            newNode.prev = temp;

            // prev pointer of node after inserted new node points to this new node
            newNode.next.prev = newNode;


        }

        length++;
        return head;
    }

    public Node delete(int index){
        if (index < 0 ){
            index = 0;
        }
        if (index == 0) {
            head = head.next;
        }


        Node temp = head;
        for (int i = 0 ; i < index -1; i++) {
            temp = temp.next;
        }
        /* for garbage collection
        Node delete = null;
        delete = temp.next;
        temp.next = delete.next;

         */

        // Deletes node by having current pointer point to node after node you want to delete
        temp.next = temp.next.next;
        // Prev pointer of the node after your deleted node points to the node before deleted
        temp.next.prev = temp;
        length--;
        return head;
    }



    // Prints whole list
    public void show(){
        // Temp node to traverse list
        Node temp = head;

        while (temp.next != null)
        {
            System.out.println( temp + ", data: " + temp.data + ", next:" + temp.next + ", prev:" + temp.prev);
            temp = temp.next;
        }
        // Prints last element
        System.out.println( temp + ", data: " + temp.data + ", next:" + temp.next + ", prev:" + temp.prev);
        System.out.println("length: " + length);
    }


}