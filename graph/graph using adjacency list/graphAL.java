import java.util.*;
import java.util.LinkedList;

class GraphNode{
    String name;
    int index ;
    boolean visited = false;
    GraphNode parent;

    ArrayList<GraphNode> neighbors = new ArrayList<GraphNode>(); 

    public GraphNode(String nameValue , int indexValue){
        this.name = nameValue;
        this.index = indexValue;
    }
}
class Graph{
    ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

    public Graph(ArrayList<GraphNode> nodeList){
        this.nodeList = nodeList;
    }

    // add edge btwn nodes

    public void addUndirectedEdge(int i , int j){                   // i , j = index of edges

        GraphNode firstNode = nodeList.get(i);
        GraphNode secondtNode = nodeList.get(j);

        firstNode.neighbors.add(secondtNode);
        secondtNode.neighbors.add(firstNode);
    }

    // For printing Graph to the console

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < nodeList.size(); i++) {
        s.append(nodeList.get(i).name + ": ");
        for (int j =0; j < nodeList.get(i).neighbors.size(); j++) {
            if (j == nodeList.get(i).neighbors.size()-1 ) {
            s.append((nodeList.get(i).neighbors.get(j).name) );
            } else {
            s.append((nodeList.get(i).neighbors.get(j).name) + " -> ");
            }
        }
        s.append("\n");
        }
        return s.toString();
  }

  // bfsVisit

  void bfsVisit(GraphNode node){

    Queue<GraphNode> q = new LinkedList<GraphNode>();
    q.add(node);

    while (!q.isEmpty()) {
        GraphNode currentNode = q.remove();
        currentNode.visited = true;
        System.out.print(currentNode.name+" ");

        for (GraphNode neighbor : currentNode.neighbors) {
            if (!neighbor.visited) {
                q.add(neighbor);
                neighbor.visited = true;
            }
        }
    }
  }

  // BFS

  void BFS(){
    for (GraphNode node : nodeList) {
        if (!node.visited) {
            bfsVisit(node);
        }
    }
  }

  // dfsVisit

  void dfsVisit(GraphNode node){
    Stack<GraphNode> s = new Stack<GraphNode>();
    s.push(node);

    while (!s.isEmpty()) {
        GraphNode currentNode = s.pop();
        currentNode.visited = true;
        System.out.print(currentNode.name+" ");

        for (GraphNode neighbor : currentNode.neighbors) {
            if (!neighbor.visited) {
                s.push(neighbor);
                neighbor.visited = true;
            }
        }
    }
  }

  // DFS

  void DFS(){
    for (GraphNode node : nodeList) {
        if (!node.visited) {
            dfsVisit(node);
        }
    }
  }

  // path printing

  public void printPath(GraphNode node){
    if (node.parent != null) {
        printPath(node.parent);
    }
    System.out.print(node.name+" ");
  }

  // BFSForSSSP

  public void BFSForSSSP(GraphNode node){
        Queue<GraphNode> q = new LinkedList<GraphNode>();
        q.add(node);

        while (!q.isEmpty()) {
            GraphNode currentNode = q.remove();
            currentNode.visited = true;
            System.out.print("printing path for "+currentNode.name+" : ");
            printPath(currentNode);
            System.out.println();

            for (GraphNode neighbor : currentNode.neighbors) {
                if (! neighbor.visited) {
                    q.add(neighbor);
                    neighbor.visited = true;
                    neighbor.parent = currentNode;
                }
            }
        }
  }

}
public class graphAL {
    public static void main(String[] args) {
        
        ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

        // adding nodes to arraylist
        nodeList.add(new GraphNode("A", 0));
        nodeList.add(new GraphNode("B", 1));
        nodeList.add(new GraphNode("C", 2));
        nodeList.add(new GraphNode("D", 3));
        nodeList.add(new GraphNode("E", 4));

        Graph g = new Graph(nodeList);


        // adding edges btwn nodes
        g.addUndirectedEdge(0, 1);
        g.addUndirectedEdge(0, 2);
        g.addUndirectedEdge(0, 3);
        g.addUndirectedEdge(1, 4);
        g.addUndirectedEdge(2, 3);
        g.addUndirectedEdge(3, 4);

        System.out.println(g.toString());

        // output :

        //   A: B -> C -> D
        //   B: A -> E
        //   C: A -> D
        //   D: A -> C -> E
        //   E: B -> D

        // g.BFS();                                                    // output : A B C D E
        System.out.println();
        // g.DFS();                                                    // output : A D E C B

        g.BFSForSSSP(nodeList.get(0));

        // output :

        // printing path for A : A 
        // printing path for B : A B
        // printing path for C : A C
        // printing path for D : A D
        // printing path for E : A B E

    }
}
