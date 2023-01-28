import java.util.*;
import java.util.LinkedList;
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

    // postOrder traversal

    public void postOrder(BinaryNode node){

        if (node == null) {
            return;
        }
        postOrder(node.left);                                       // left subtree
        postOrder(node.right);                                      // rigth subtree
        System.out.println(node.value + " ");
    }

    // levelOrder traversal

    public void levelOrder(){

        Queue<BinaryNode> q = new LinkedList<BinaryNode>();         // creation of queue using linked list
        q.add(root);

        while (!q.isEmpty()) {
            BinaryNode currentNode = q.remove();
            System.out.println( currentNode.value + " ");

            if (currentNode.left != null) {
                q.add(currentNode.left);
            }
            if (currentNode.left != null) {
                q.add(currentNode.left); 
            }
        }
    }

    // searching in binary tree

    public void search(String key){

        Queue<BinaryNode> q = new LinkedList<BinaryNode>();
        q.add(root);

        while (!q.isEmpty()) {
            BinaryNode currentNode = q.remove();

            if (currentNode.value == key) {
                System.out.println(key + " found in tree");
                return;
            } else {
                if (currentNode.left != null) {
                    q.add(currentNode.left);
                } 
                if (currentNode.right != null) {
                    q.add(currentNode.right);
                }
            }
        }
        System.out.println(key + " not found in tree");
    }
}
public class binaryTreeLL {
    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree();

    }
}
