class BinaryNode{

    public String value;
    public BinaryNode left;
    public BinaryNode right;
    public int height;                                             // useful in other operations
}
class BinaryTree{
    BinaryNode root;

    public BinaryTree(){
        this.root = null;
    }

    // PreOrder traversal

    public void PreOrder(BinaryNode node){

        if (node == null) {
            return;
        }
        System.out.println(node.value + " ");                       // root
        PreOrder(node.left);                                        // left subtree
        PreOrder(node.right);                                       // rigth subtree
    }
}
public class binaryTreeLL {
    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree();

    }
}
