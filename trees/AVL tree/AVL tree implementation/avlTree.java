import java.util.*;
import java.util.LinkedList;
class BinaryNode{
    public int value;
    public int height;
    public BinaryNode left;
    public BinaryNode right;

    public BinaryNode(){
        this.height = 0;
    }
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

    // searching in AVL tree

    public BinaryNode search(BinaryNode node , int key){
        if (node == null) {
            System.out.println(key + " not found in tree");
            return null;
        }
        else if (node.value == key) {
            System.out.println(key + " found in tree");
            return node;
        }
        else if (key < node.value) {
            return search(node.left, key);
        }
        else {
            return search(node.right, key);
        }
    }

    // getHeight of node

    public int getHeight(BinaryNode node){
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    // rotate right 

    private BinaryNode rotateRight(BinaryNode disbalancedNode){

        BinaryNode newRoot = disbalancedNode.left;
        disbalancedNode.left = disbalancedNode.left.right;
        newRoot.right = disbalancedNode;

        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));

        return newRoot;
    }

    // rotate left

    private BinaryNode rotateLeft(BinaryNode disbalancedNode){

        BinaryNode newRoot = disbalancedNode.right;
        disbalancedNode.right = disbalancedNode.right.left;
        newRoot.left = disbalancedNode;

        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));        

        return newRoot;
    }

    // getBalance

    public int getBalance(BinaryNode node){
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    // insertNode 

    private BinaryNode insertNode(BinaryNode node , int nodeValue){

        if (node == null) {
            BinaryNode newNode = new BinaryNode();
            newNode.value = nodeValue;
            newNode.height = 1;
            return newNode;
        }
        else if (nodeValue < node.value) {
            node.left =  insertNode(node.left, nodeValue);
        }
        else{
            node.right = insertNode(node.right, nodeValue);
        }

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balance = getBalance(node);

        if (balance > 1 && nodeValue < node.left.value) {             // left left condition
            return rotateRight(node);
        }

        if (balance > 1 && nodeValue > node.left.value) {           // left rigth condition
            node.left = rotateLeft(node.left);                      // first left rotate child of node
            return rotateRight(node);                                // then right rotate the node
        }

        if (balance < -1 && nodeValue > node.right.value) {          // right right condiion
            return rotateLeft(node);
        }

        if (balance < -1 && nodeValue < node.right.value) {          // right left condition
            node.right = rotateRight(node.right);                   // first right rotate child of node
            return rotateLeft(node);                                // then left rotate the node
        }
        return node;
    }
   
    public void insert(int nodeValue){
        root = insertNode(root, nodeValue);
    }

     // // Minimum node
  public static BinaryNode minimumNode(BinaryNode root) {
    if (root.left == null) {
      return root;
    } else {
      return minimumNode(root.left);
    }
  }

  // Delete node
 public BinaryNode deleteNode(BinaryNode node, int value) {

   if (node == null) {
     System.out.println("Value not found in AVL");
     return node;
   }

   if (value < node.value) {
     node.left = deleteNode(node.left, value);

   } else if (value > node.value) {
     node.right = deleteNode(node.right, value);

   } else {

     if (node.left != null && node.right != null) {

       BinaryNode temp = node;
       BinaryNode minNodeForRight = minimumNode(temp.right);
       node.value = minNodeForRight.value;
       node.right = deleteNode(node.right, minNodeForRight.value);

     } else if (node.left != null) {
       node = node.left;
     } else if (node.right != null) {
       node = node.right;
     } else {
       node = null;
     }
   }

   // Case 2 - rotation required

   int balance = getBalance(node);

   if (balance > 1 && getBalance(node.left) >= 0) {
     return rotateRight(node);
   }
   if (balance > 1 && getBalance(node.left) < 0) {
     node.left = rotateLeft(node.left);
     return rotateRight(node);
   }
   if (balance < -1 && getBalance(node.right) <= 0) {
     return rotateLeft(node);
   }

   if (balance < -1 && getBalance(node.right) > 0) {
     node.right = rotateRight(node.right);
     return rotateLeft(node);
   }

   return node;

 }

 public void delete(int value) {
   root = deleteNode(root, value);
 }

}
public class avlTree {
    public static void main(String[] args) {

        AVL at = new AVL();
        at.insert(5);
        at.insert(10);
        at.insert(15);
        at.insert(20);

        at.levelOrder();                                            // output : 10 5 15 20 (before deletion)
        at.delete(5);
        System.out.println();
        at.levelOrder();                                            // output : 15 10 20
    }
}
