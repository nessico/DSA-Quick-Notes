public class Stacky {
    Node top;
    Node bottom;
    int length = 0;

    public Node peek() {
        if (top == null) {
            System.out.println("Stack is Empty");
            return null;
        }
        else {
            System.out.println("Peek " + top.data);
            return top;
        }
    }

    public Node push(int data){
        Node addNode = new Node(data);
        if (this.length == 0) {
            top = addNode;
            bottom = addNode;
        } else {
            // New node will point to previous top, add the new node as the top
            // Because Stack is LIFO
            addNode.next = top;
            top = addNode;
        }
        length++;
        System.out.println("Push: " + top.data);
        return top;
    }

    public Node pop(){
        if (top == null) {
            System.out.println("Stack is empty");
            return null;
        }
        Node delNode = top;
        top = top.next;
        System.out.println("Popped: " + delNode.data);
        length--;
        return delNode;
    }
}
