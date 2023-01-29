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
}
public class binarySearchTree {
    public static void main(String[] args) {

        BST bst = new BST();                                        // output : BST is created with null root node
    }
}
