import java.util.*;
import java.util.LinkedList;
class BinaryNode{

    public String value;
    public BinaryNode left;
    public BinaryNode right;
    public int height;                                             // useful in other operations
}
class BinaryTree{
    public BinaryNode root;

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
        preOrder(node.right);                                       // right subtree
    }

    // inOrder traversal

    public void inOrder(BinaryNode node){

        if (node == null) {
            return; 
        }
        inOrder(node.left);                                         // left subtree
        System.out.print(node.value + " ");
        inOrder(node.right);                                        // right subtree
    }

    // postOrder traversal

    public void postOrder(BinaryNode node){

        if (node == null) {
            return;
        }
        postOrder(node.left);                                       // left subtree
        postOrder(node.right);                                      // right subtree
        System.out.print(node.value + " ");
    }

    // levelOrder traversal

    public void levelOrder(){

        Queue<BinaryNode> q = new LinkedList<BinaryNode>();         // creation of queue using linked list
        q.add(root);

        while (!q.isEmpty()) {
            BinaryNode currentNode = q.remove();
            System.out.print( currentNode.value + " ");

            if (currentNode.left != null) {
                q.add(currentNode.left);
            }
            if (currentNode.right != null) {
                q.add(currentNode.right); 
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

    // insertion in binary tree

    public void insertion(String nodeValue){
        BinaryNode node = new BinaryNode();
        node.value =nodeValue;

        if (root == null) {
            root = node;
            System.out.println(nodeValue + " inserted successfully");
            return;
        }

        Queue<BinaryNode> q = new LinkedList<BinaryNode>();
        q.add(root);

        while (! q.isEmpty()) {
            BinaryNode currentNode = q.remove();

            if (currentNode.left == null) {
                currentNode.left = node;
                System.out.println(nodeValue + " inserted successfully");
                break;
                
            } else if (currentNode.right == null) {
                currentNode.right = node;
                System.out.println(nodeValue + " inserted successfully");
                break;
            } 
            else{
                q.add(currentNode.left);
                q.add(currentNode.right);  
            }
        }
    }


    // ----------------------DELETION OF NODE --------------------- 

    // get the deepest node of tree

    public BinaryNode deepestNode(){
        Queue<BinaryNode> q = new LinkedList<BinaryNode>();
        q.add(root);

        BinaryNode currentNode = null;

        while(!q.isEmpty()){
            currentNode = q.remove();

            if (currentNode.left != null) {
                q.add(currentNode.left);
            }
            if (currentNode.right != null) {
                q.add(currentNode.right);
            }
        }
        return currentNode;
    }

    // delete the deepest node in binary tree

    public void deleteDeepest(){
        Queue<BinaryNode> q = new LinkedList<BinaryNode>();
        q.add(root);

        BinaryNode prevNode , CurrentNode = null;

        while (! q.isEmpty()) {
            prevNode = CurrentNode;
            CurrentNode = q.remove();

            if (CurrentNode.left == null) {
                prevNode.right = null;
                return;
            } else if (CurrentNode.right == null) {
                CurrentNode.left =null;
                return; 
            }
            else{
                q.add(CurrentNode.left);
                q.add(CurrentNode.right);
            }
        }
    }

    // delete given node 

    public void deleteNode(String key){
        Queue<BinaryNode> q = new LinkedList<BinaryNode>();
        q.add(root);

        while (!q.isEmpty()) {
            BinaryNode currentNode = q.remove();

            if (currentNode.value == key) {                         // find the node you want to delete
                currentNode.value = deepestNode().value;            // find the deepest node & set the node value to deepest node value
                deleteDeepest();                                    // delete the deepest node
                System.out.println(key +" is deleted");
                return;
            } else {
                if (currentNode.left != null) {
                    q.add(currentNode.left);
                    q.add(currentNode.right);
                }
            }
        }
        System.out.println(key + " not exist in binary tree");
    }

    // delete entire tree

    public void deleteBT(){
        root =null;
        System.out.println("entire tree is deleted");
    }
}
public class binaryTreeLL {
    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree();

        bt.insertion("N1");                                         // output : N1 inserted successfully
        bt.insertion("N2");                                         // output : N2 inserted successfully
        bt.insertion("N3");                                         // output : N3 inserted successfully
        bt.insertion("N4");                                         // output : N4 inserted successfully
        bt.insertion("N5");                                         // output : N5 inserted successfully
        bt.insertion("N6");                                         // output : N6 inserted successfully
        bt.insertion("N7");                                         // output : N7 inserted successfully
        bt.insertion("N8");                                         // output : N8 inserted successfully
        bt.insertion("N9");                                         // output : N9 inserted successfully

        bt.preOrder(bt.root);                                       // output : N1 N2 N4 N8 N9 N5 N3 N6 N7
        System.out.println();
        bt.inOrder(bt.root);                                        // output : N8 N4 N9 N2 N5 N1 N6 N3 N7
        System.out.println();
        bt.postOrder(bt.root);                                      // output : N8 N9 N4 N5 N2 N6 N7 N3 N1 
        System.out.println();
        bt.levelOrder();                                            // output : N1 N2 N3 N4 N5 N6 N7 N8 N9(before deletion)
        System.out.println();

        bt.search("N6");                                            // output : N6 found in tree
        bt.search("N10");                                            // output : N10 not found in tree
        bt.deleteNode("N3");                                        // output : N3 is deleted

        bt.levelOrder();                                             // output : N1 N2 N9 N4 N5 N6 N7 N8 (after deletion)
        System.out.println();
        bt.deleteBT();                                              // output : entire tree is deleted


    }
}
