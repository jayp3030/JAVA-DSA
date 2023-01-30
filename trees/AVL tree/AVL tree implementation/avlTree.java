import java.util.*;
import java.util.LinkedList;
class BinaryNode{
    public int value;
    public int height;
    public BinaryNode left;
    public BinaryNode right;
}
class AVL{

    BinaryNode root;

    public AVL(){
        root = null;
        System.out.println("AVL tree created successfully");
    }

    // preOrder traversal

    public void preOrder(BinaryNode node){
        if (node == null) {
            return; 
        }
        System.out.print(node.value+ " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // inOrder traversal

    public void inOrder(BinaryNode node){
        if (node == null) {
            return; 
        }
        inOrder(node.left);
        System.out.print(node.value+ " ");
        inOrder(node.right);
    }

    // posOrder traversal

    public void postOrder(BinaryNode node){
        if (node == null) {
            return; 
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value+ " ");
    }

    // levelOrder traversal

    public void levelOrder(){
        Queue<BinaryNode> q = new LinkedList<BinaryNode>();
        q.add(root);

        while (!q.isEmpty()) {
            BinaryNode currentNode = q.remove();
            System.out.print(currentNode.value + " ");

            if (currentNode.left != null) {
                q.add(currentNode.left);
            }

            if (currentNode.right != null) {
                q.add(currentNode.right);
            }
        }
    }
}
public class avlTree {
    public static void main(String[] args) {
        
        AVL at = new AVL();                                         // output : AVL tree created successfully
    }
}
