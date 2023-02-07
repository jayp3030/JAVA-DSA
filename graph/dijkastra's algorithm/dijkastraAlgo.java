import java.util.*;

class WeightedNode implements Comparable<WeightedNode>{

    String name ;
    WeightedNode parent;
    ArrayList<WeightedNode> neighbors = new ArrayList<WeightedNode>();
    HashMap<WeightedNode , Integer> weightMap = new HashMap<>();
    boolean visited = false;
    int distance;
    int index;

    public WeightedNode(String nameValue , int indexValue){
        this.name = nameValue;
        this.index = indexValue;
        this.distance = Integer.MAX_VALUE;
    }

    @Override

    public String toString(){
        return name;
    }

    @Override

    public int compareTo(WeightedNode node){
        return this.distance - node.distance;
    }
}
class weightedGraph{

    ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();

    public weightedGraph(ArrayList<WeightedNode> nodeList){
        this.nodeList = nodeList;
    }

    // dijkastra's algo

    void dijkastra(WeightedNode node){
        PriorityQueue<WeightedNode> q = new PriorityQueue<>();
        node.distance = 0;
        q.addAll(nodeList);

        while (!q.isEmpty()) {
            WeightedNode currentNode = q.remove();

            for (WeightedNode neighbor : currentNode.neighbors) {
                if (q.contains(neighbor)) {
                    if (neighbor.distance > currentNode.distance + currentNode.weightMap.get(neighbor)) {
                        neighbor.distance = currentNode.distance + currentNode.weightMap.get(neighbor);
                        neighbor.parent = currentNode;
                        q.remove(neighbor);
                        q.add(neighbor);
                    }
                }
                
            }
        }

        for (WeightedNode nodeToCheck : nodeList) {
            System.out.print("Node "+nodeToCheck+" distance : "+nodeToCheck.distance+" Path : ");
            printPath(nodeToCheck);
            System.out.println();
            
        }
    }

    // add weighted node

    void addWeightedNode(int i , int j , int distance){
        WeightedNode first = nodeList.get(i);
        WeightedNode second = nodeList.get(j);
        first.neighbors.add(second);
        first.weightMap.put(second, distance);
    }

    // PRINT PATH

    public void printPath(WeightedNode node){
        if (node.parent != null) {
            printPath(node.parent);
        }
        System.out.print(node.name+" ");
      }
}
public class dijkastraAlgo {
    public static void main(String[] args) {
        
        ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();

        nodeList.add(new WeightedNode("A", 0));
        nodeList.add(new WeightedNode("B", 1));
        nodeList.add(new WeightedNode("C", 2));
        nodeList.add(new WeightedNode("D", 3));
        nodeList.add(new WeightedNode("E", 4));
        nodeList.add(new WeightedNode("F", 5));
        nodeList.add(new WeightedNode("G", 6));

        weightedGraph g = new weightedGraph(nodeList);

        g.addWeightedNode(0, 1, 2);
        g.addWeightedNode(0, 2, 5);
        g.addWeightedNode(1, 2, 6);
        g.addWeightedNode(1, 3, 1);
        g.addWeightedNode(1, 4, 3);
        g.addWeightedNode(2, 5, 8);
        g.addWeightedNode(2, 4, 4);
        g.addWeightedNode(4, 6, 9);
        g.addWeightedNode(5, 6, 7);

        System.out.println("Printing dijkastra from source A : ");
        g.dijkastra(nodeList.get(0));

        // output:

        // Printing dijkastra from source A : 
                
        // Node A distance : 0 Path : A 
        // Node B distance : 2 Path : A B
        // Node C distance : 5 Path : A C
        // Node D distance : 3 Path : A B D
        // Node E distance : 5 Path : A B E
        // Node F distance : 13 Path : A C F
        // Node G distance : 14 Path : A B E G
    }
}
