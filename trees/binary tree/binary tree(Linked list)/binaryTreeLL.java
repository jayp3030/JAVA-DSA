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

    // preOrder traversal

    public void preOrder(BinaryNode node){

        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");                       
        preOrder(node.left);                                        // left subtree
        preOrder(node.right);                                       // rigth subtree
    }

    // inOrder traversal

    public void inOrder(BinaryNode node){

        if (node == null) {
            return; 
        }
        inOrder(node.left);                                         // left subtree
        System.out.print(node.value + " ");
        inOrder(node.right);                                        // righ subtree
    }
}
public class binaryTreeLL {
    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree();

    }
}
