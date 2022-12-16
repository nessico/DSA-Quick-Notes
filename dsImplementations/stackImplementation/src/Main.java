public class Main {

    public static void main(String[] args) {
	Stacky stack = new Stacky();

	stack.push(5);
	stack.push(10);
	stack.push(20);
	stack.pop();
	stack.peek();
	stack.pop();
	stack.pop();
	System.out.println("length: " + stack.length);
    }
}
