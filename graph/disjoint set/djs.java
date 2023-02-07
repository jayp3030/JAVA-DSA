import java.util.*;

class WeightedNode implements Comparable<WeightedNode> {

    public String name;
    public ArrayList<WeightedNode> neighbors = new ArrayList<WeightedNode>();
    public HashMap<WeightedNode, Integer> weightMap = new HashMap<>();
    public boolean isVisited = false;
    public WeightedNode parent;
    public int distance;
    public DisjointSet set;

    public WeightedNode(String name) {
        this.name = name;
        distance = Integer.MAX_VALUE;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(WeightedNode o) {
        return this.distance - o.distance;
    }

}

class DisjointSet {

    ArrayList<WeightedNode> nodeList = new ArrayList<>();

    // make set method
    public static void makeSet(ArrayList<WeightedNode> nodeList) {
        for (WeightedNode node : nodeList) {
            DisjointSet set = new DisjointSet();
            set.nodeList.add(node);
            node.set = set;
        }
    }

    // find set

    public static DisjointSet findSet(WeightedNode node) {
        return node.set;
    }

    // union method

    public static DisjointSet union(WeightedNode node1, WeightedNode node2) {
        if (node1.set.equals(node2.set)) {
            return null;
        } else {
            DisjointSet set1 = node1.set;
            DisjointSet set2 = node2.set;

            if (set1.nodeList.size() > set2.nodeList.size()) {
                ArrayList<WeightedNode> nodeSet2 = set2.nodeList;
                for (WeightedNode node : nodeSet2) {
                    node.set = set1;
                    set1.nodeList.add(node);
                }
                return set1;
            } else {
                ArrayList<WeightedNode> nodeSet1 = set1.nodeList;
                for (WeightedNode node : nodeSet1) {
                    node.set = set2;
                    set2.nodeList.add(node);
                }
                return set2;
            }
        }
    }

    // print node of set

    public void printAllNodesofThisSet() {
        System.out.print("Printing all nodes of the set: ");
        for (WeightedNode node : nodeList) {
            System.out.print(node + " ");
        }
        System.out.println();
    }

}

public class djs {
    public static void main(String[] args) {
        
        ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();

        nodeList.add(new WeightedNode("A"));
        nodeList.add(new WeightedNode("B"));
        nodeList.add(new WeightedNode("C"));
        nodeList.add(new WeightedNode("D"));
        nodeList.add(new WeightedNode("E"));

        DisjointSet.makeSet(nodeList);

        WeightedNode first = nodeList.get(0);
        WeightedNode second = nodeList.get(1);

        DisjointSet output = DisjointSet.findSet(second);
        output.printAllNodesofThisSet();                            // output : Printing all nodes of the set: B
        
                                            
        DisjointSet.union(first, second);
        output = DisjointSet.findSet(first);
        output.printAllNodesofThisSet();                            // output : Printing all nodes of the set: B A
    }
}
