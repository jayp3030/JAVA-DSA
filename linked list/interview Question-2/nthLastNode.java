import java.util.*;

class Node{
    public int value;
    public Node next;
    public Node prev;
}
class LinkedList{

    Node head;
    Node tail;
    int size;

    public void creatLL(int nodeValue){

        Node node = new Node();

        node.value = nodeValue;
        node.next = null;

        head=node;
        tail=node;
        size=1;
    }

    public void insertNode(int nodeValue){
        Node node = new Node();
        node.value = nodeValue;
        node.next = null;
        tail.next = node;
        tail = node;
        size++;
    }

    public void traverseLL(){

        Node currentNode = head;
        int index = 0;

        while (index<size) {
            System.out.print(currentNode.value);

            if (currentNode.next != null) {
                System.out.print(" -> ");
            }
            currentNode = currentNode.next;
            index++;
        }
    }

}

class Solution{

    public Node nthLastNode(LinkedList ll , int nthValue){          // nthValue = last nth node
        Node p1 = ll.head;
        Node p2 = ll.head;

        for (int i = 0; i < nthValue; i++) {
            if (p1 == null) {
                return null;
            }
            p2 = p2.next;
        }

        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

}

public class nthLastNode {
    public static void main(String[] args) {

        LinkedList ll = new LinkedList();
        
        ll.creatLL(1);
        ll.insertNode(2);
        ll.insertNode(3);
        ll.insertNode(4);
        ll.insertNode(5);
        ll.traverseLL();                                            // output : 1 -> 2 -> 3 -> 4 -> 5                             
        System.out.println();

        Solution sl = new Solution();

        System.out.println(sl.nthLastNode(ll, 2).value);            // output : 4

    }
}
