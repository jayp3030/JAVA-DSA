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

    public void removeDuplicate(LinkedList ll){
         HashSet<Integer> hs = new HashSet<>();
         Node prev = null;
         Node current = ll.head;
         
         while(current != null){

            Node nextNode = current.next;
            int currVal = current.value;
            if (hs.contains(currVal)) {                             // delete current
                prev.next = nextNode;
                ll.size--;
            } else {                                                // add currVal to hashset
                hs.add(currVal);
                prev = current;
            }
            current = current.next;
         }
    }

}
public class removeDuplicates {
    public static void main(String[] args) {

        LinkedList ll = new LinkedList();
        
        ll.creatLL(1);
        ll.insertNode(2);
        ll.insertNode(3);
        ll.insertNode(2);
        ll.insertNode(5);
        ll.traverseLL();                                            // before removal output : 1 -> 2 -> 3 -> 2 -> 5
        System.out.println();
        
        Solution sl = new Solution();

        sl.removeDuplicate(ll);
        ll.traverseLL();                                            // after removal output : 1 -> 2 -> 3 -> 5
    }
}
