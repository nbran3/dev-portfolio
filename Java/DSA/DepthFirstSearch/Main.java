public class Main {
    public static void main(String[] args) {

        Graph graph = new Graph(5);
        graph.addNode(new Node('a'));
        graph.addNode(new Node('b'));
        graph.addNode(new Node('c'));
        graph.addNode(new Node('d'));
        graph.addNode(new Node('e'));

        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(2,3);
        graph.addEdge(2,4);
        graph.addEdge(4,0);
        graph.addEdge(4,2);

        graph.print();
        graph.depthFirstSearch(4);


    }
}
