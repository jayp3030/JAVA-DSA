import java.util.*;

class GraphNode{
    String name;
    int index ;

    public GraphNode(String nameValue , int indexValue){
        this.name = nameValue;
        this.index = indexValue;
    }
}
class Graph{
    ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
    int [][] adjacencyMatrics ;

    public Graph(ArrayList<GraphNode> nodeList){
        this.nodeList = nodeList;
        adjacencyMatrics = new int [nodeList.size()][nodeList.size()];
    }

    // add edge between nodes

    public void addUndirectedEdge(int i , int j ){                  // i ,j  = index of node 
        adjacencyMatrics[i][j] = 1;
        adjacencyMatrics[j][i] = 1;
    }

    // to print adjacency metrics

    public String toString() {                                      // copy paste
        StringBuilder s = new StringBuilder();
        s.append("   ");
        for (int i = 0; i < nodeList.size(); i++) {
          s.append(nodeList.get(i).name + " ");
        }
        s.append("\n");
        for (int i = 0; i < nodeList.size(); i++) {
          s.append(nodeList.get(i).name + ": ");
          for (int j : adjacencyMatrics[i]) {
            s.append((j) + " ");
          }
          s.append("\n");
        }
        return s.toString();
      }

}
public class graphAM {
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
        
       // output :       A B C D E 
       //             A: 0 1 1 1 0
       //             B: 1 0 0 0 1
       //             C: 1 0 0 1 0
       //             D: 1 0 1 0 1
       //             E: 0 1 0 1 0

    }
}
