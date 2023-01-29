class BinaryNode{
    public int value;
    public BinaryNode left;
    public BinaryNode right;
    public int height;
}
class BST{

    BinaryNode root;

    public BST(){
        this.root = null;
        System.out.println("BST is created with null root node");
    }

    // insertion in BST

    private BinaryNode insertion(BinaryNode currentNode , int value){

        if (currentNode== null) {
            BinaryNode node = new BinaryNode();
            node.value = value;
            System.out.println(value + " successfully inserted");
            return currentNode;
        } else if (value <= currentNode.value) {
            currentNode.left = insertion(currentNode.left, value);
            return currentNode;
        } else{
           currentNode.right = insertion(currentNode.right, value);
           return currentNode; 
        }
    }

    public void insert(int nodeValue){
        insertion(root, nodeValue);
    }
}
public class binarySearchTree {
    public static void main(String[] args) {

        BST bst = new BST();                                        // output : BST is created with null root node

        bst.insert(60);                                             // output : 60 successfully inserted
        bst.insert(20);                                             // output : 20 successfully inserted
        bst.insert(30);                                             // output : 30 successfully inserted
        bst.insert(80);                                             // output : 80 successfully inserted
        bst.insert(10);                                             // output : 10 successfully inserted
        bst.insert(70);                                             // output : 70 successfully inserted
    }
}
