public class Main {

    public static void main(String[] args) {

      Graph graph = new Graph();

      graph.addVertex(0);
      graph.addVertex(1);
      graph.addVertex(2);
      graph.addVertex(3);
      graph.addVertex(4);
      graph.addEdge(0, 1);
      graph.addEdge(1, 0);
      graph.addEdge(1, 4);
      graph.addEdge(3, 1);
      graph.addEdge(4, 1);
      graph.addEdge(4, 2);
      graph.addEdge(4, 0);

        graph.printGraph();
    }
}
