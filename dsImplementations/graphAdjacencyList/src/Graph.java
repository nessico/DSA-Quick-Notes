import java.util.*;

public class Graph {
    // Adjacency List
    ArrayList<LinkedList<Integer>> adjacencyList = new ArrayList<LinkedList<Integer>>();


    public void addVertex(int value) {
        LinkedList<Integer> newVertex = new LinkedList<Integer>();
        newVertex.add(value);

        // Move the LinkedList to ArrayList
        adjacencyList.add(newVertex);

    }

    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
    }

    public void printGraph() {
        for (LinkedList<Integer> inner : adjacencyList) {
            System.out.print(inner.getFirst() + " -> ");
            for (int i = 1; i < inner.size(); i++) {
                System.out.print(inner.get(i) + ", ");
            }
            System.out.println();
        }
    }
}
