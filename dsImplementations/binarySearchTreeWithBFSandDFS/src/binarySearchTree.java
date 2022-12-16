import java.util.*;

public class binarySearchTree {
    Node root = null;
    int treeLength = 0;

    // For print2D function
    static final int COUNT = 10;


    public Node insert(int value){
        // Initialize new node to be inserted
        Node newNode = new Node(value);

        // Set new node as root if tree is empty
        if ( root == null) {
            root = newNode;
            treeLength++;
            return newNode;
        }

        // set temp currentNode for traversal
        Node currentNode = root;

        while(true) {
            // left
            if (value < currentNode.data) {
                // Insert if left of traversed node is empty
                if (currentNode.left == null) {
                    currentNode.left = newNode;
                    treeLength++;
                    return newNode;
                }
                // if not empty, keep traversing
                currentNode = currentNode.left;
            }
            // right
            else if (value > currentNode.data) {
                // Insert if right of traversed node is empty
                if (currentNode.right == null) {
                    currentNode.right = newNode;
                    treeLength++;
                    return newNode;
                }
                // If not empty, keep traversing
                currentNode = currentNode.right;
            }
        }


    }

    // Check if the node/value ur existing for exists

    public boolean lookup(int value) {
        System.out.println("Key " + value + " exists: ");
        if (root == null) {
            return false;

        }
        Node currentNode = root;
        // set temp currentNode for traversal, if currentNode finishes traversing and there's nothing left then exit
        while (currentNode != null) {
            // left
            if (value < currentNode.data ) {
                currentNode = currentNode.left;
            }
            // right
            else if (value > currentNode.data ) {
                currentNode = currentNode.right;
            } else if (currentNode.data == value) {
                return true;
            }
        }
        return false;
    }

    public Node remove(int value){
        if (root == null) {
            System.out.println("Tree is empty, nothing to delete");
            return null;
        }

        Node currentNode = root; // For traversal to node you want to delete
        Node parentNode = null; // Reference to parent node of node you want to delete

        // traverse
        while (currentNode != null && currentNode.data != value) {
            // save parent ref
            parentNode = currentNode;
            // left
            if (value < currentNode.data) {
                currentNode = currentNode.left;
            }
            // right
            else if (value > currentNode.data) {
                currentNode = currentNode.right;
            }
        }
        // Match, value == currentNode.data
        // Node to be deleted is the root node
        if (parentNode == null) {
            treeLength--;
            return removeThisNode(currentNode);
        }
        // Node to be deleted is left of parent
        if (parentNode.left == currentNode) {
            parentNode.left = removeThisNode(currentNode);
        }
        // Node to be deleted is right of parent
        else if (parentNode.right == currentNode) {
            parentNode.right = removeThisNode(currentNode);
        }
        treeLength--;
              return root;
    }

    private Node removeThisNode(Node curr) {

        // 1 child case

        // No left child, return right child, so it can be overwritten
        if (curr.left == null) {
            return curr.right;
        }
        // No right child, return left child, so it can be overwritten
        if (curr.right == null) {
            return curr.left;
        }

        // 2 child case

        // Find min node in right child subtree
        // Append curr.left to minNode.left, so it saves deleted node's left subtree
        // Return right subtree, so it can be overwritten

        Node minNode = findMin(curr.right);
        minNode.left = curr.left;
        return curr.right;
    }

    public void breadthFirstSearch(){

        // Temp Node for traversal
        Node currentNode = root;

        // Optional, but mandatory for Graphs
        ArrayList<Integer> visited = new ArrayList<Integer>();


        Queue<Node> queue = new LinkedList<Node>();
        queue.add(currentNode);

        while (queue.size() != 0) {
            currentNode = queue.poll();
            visited.add(currentNode.data);

            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }

        }


       System.out.println("bfs: " + visited);
    }

    public void inOrder() {
        Node currentNode = root;
        System.out.print("InOrder: ");
        dfsInOrder(currentNode);
        System.out.println();
    }
    public static void dfsInOrder(Node root) {
        if (root.left != null ){
            dfsInOrder(root.left);
        }
        System.out.print(root.data + " "); // inOrder
        if (root.right != null ){
            dfsInOrder(root.right);
        }
    }

    public void preOrder() {
        Node currentNode = root;
        System.out.print("preOrder: ");
        dfsPreOrder(currentNode);
        System.out.println();
    }
    public static void dfsPreOrder(Node root) {
        System.out.print(root.data + " "); // preOrder
        if (root.left != null ){
            dfsPreOrder(root.left);
        }
        if (root.right != null ){
            dfsPreOrder(root.right);
        }
    }

    public void postOrder() {
        Node currentNode = root;
        System.out.print("postOrder: ");
        dfsPostOrder(currentNode);
        System.out.println();
    }
    public static void dfsPostOrder(Node root) {
        if (root.left != null ){
            dfsPostOrder(root.left);
        }
        if (root.right != null ){
            dfsPostOrder(root.right);
        }
        System.out.print(root.data + " "); // postOrder
    }


    private Node findMin(Node curr) {
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    // GFG helper function to print tree
    public static void print2DUtil(Node root, int space)
    {
        // Base case
        if (root == null)
            return;

        // Increase distance between levels
        space += COUNT;

        // Process right child first
        print2DUtil(root.right, space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.data + "\n");

        // Process left child
        print2DUtil(root.left, space);
    }

    // Wrapper over print2DUtil()
    public void print2D()
    {
        // Pass initial space count as 0
        Node printNode = root;
        print2DUtil(printNode, 0);
    }

}
