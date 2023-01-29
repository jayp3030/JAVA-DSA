import java.util.*;
import java.util.LinkedList;
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

        if (currentNode == null) {
            BinaryNode node = new BinaryNode();
            node.value = value;
            System.out.println(value + " successfully inserted");
            return node;
        } else if (value <= currentNode.value) {
            currentNode.left = insertion(currentNode.left, value);
            return currentNode;
        } else{
           currentNode.right = insertion(currentNode.right, value);
           return currentNode; 
        }
    }
 
    public void insert(int nodeValue){
       root = insertion(root, nodeValue);
    }

    // preOrder traversal in BST

    public void preOrder(BinaryNode node){
        if (node == null) {
            return;
        }
        System.out.print(node.value +" ");
        preOrder(node.left);
        preOrder(node.right);
    }
     
    // inOreder traversal

    public void inOrder(BinaryNode node){
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value +" ");
        inOrder(node.right);
    }

    // postOreder traversal

    public void postOrder(BinaryNode node){
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value +" ");
    }

    // levelOrder traversal

    public void levelOrder(){
        Queue<BinaryNode> q = new LinkedList<BinaryNode>();
        q.add(root);

        while(!q.isEmpty()){
            BinaryNode currentNode = q.remove();
            System.out.print(currentNode.value+ " ");
            if (currentNode.left != null) {
                q.add(currentNode.left);
            }
            if (currentNode.right != null) {
                q.add(currentNode.right);
            }{
                
            }
        }
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


        bst.preOrder(bst.root);                                     // output : 60 20 10 30 80 70 
        System.out.println();
        bst.inOrder(bst.root);                                     // output : 10 20 30 60 70 80  
        System.out.println();
        bst.postOrder(bst.root);                                     // output : 10 30 20 70 80 60
        System.out.println();
        bst.levelOrder();                                           // output : 60 20 80 10 30 70
        
    }
}
