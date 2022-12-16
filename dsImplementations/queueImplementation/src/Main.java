public class Main {

    public static void main(String[] args) {
	testQueue queue = new testQueue();
	queue.add(2);
	queue.add(5);
	queue.add(10);
	queue.remove();
		queue.remove();
		queue.peek();
		queue.remove();
	System.out.println("Length: " + queue.length);
    }
}
