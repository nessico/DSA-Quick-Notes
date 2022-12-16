public class Main {

    public static void main(String[] args) {
	binarySearchTree tree = new binarySearchTree();
	tree.insert(8);
	tree.insert(4);
	tree.insert(2);
	tree.insert(6);
	tree.insert(10);
		tree.insert(9);
	tree.insert(20);
	System.out.println(tree.lookup(4));
	System.out.println(tree.lookup(9));

	tree.print2D();
	System.out.println("number of nodes =" + tree.treeLength);
	tree.breadthFirstSearch();

	tree.inOrder();
	tree.preOrder();
	tree.postOrder();
	tree.remove(4);

	System.out.println("------------------------------------");
		System.out.println("number of nodes =" + tree.treeLength);
	tree.print2D();
	tree.breadthFirstSearch();
		tree.inOrder();
		tree.preOrder();
		tree.postOrder();
    }
}
