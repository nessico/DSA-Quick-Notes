public class testQueue {
    Node first;
    Node last;
    int length = 0;

    public Node peek() {
        System.out.println("Peek: " + first.data);
        return first;
    }

    public Node add(int d){
        Node addNode = new Node(d);

        // if queue is empty, this added node should be the first and last node
        if (first == null) {
            first = addNode;
        }
        // If this isn't the first node ever added, then previous node before should point to this new node
        if (last != null) {
            last.next = addNode;
        }

        // FIFO, the new node should be in the back of the line
        last = addNode;

        System.out.println("Added node is: " + addNode.data);
        length++;
        return first;
    }

    public Node remove(){
        if (first == null) {
            System.out.println("Queue is empty, nothing to remove");
            return null;
        }

        // Temp placeholder to show removed node
        Node removedNode = first;

        // FIFO, the new first is set next to removedFirst
        first = first.next;

        // If removed node was the last in queue, then set last to null too
        if (first == null) {
            last = null;
        }
        System.out.println("Removed: " + removedNode.data);
        length--;
        return removedNode;
    }
}
