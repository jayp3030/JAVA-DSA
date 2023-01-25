
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

    public LinkedList partitionAroundX(LinkedList ll , int x){

        Node currentNode = ll.head;
        ll.tail = ll.head;
    
        while (currentNode != null) {
            Node nextNode = currentNode.next;
            if (currentNode.value < x) {                            // curVal < x so insert node at beggining
                currentNode.next = ll.head;
                ll.head = currentNode;
            }
            else{                                                   // curVal > x so insert node at end
                ll.tail.next = currentNode;
                ll.tail = currentNode;
            }
            currentNode = nextNode;
        }
        ll.tail.next = null;
        return ll;
    }

}

public class partition {
    public static void main(String[] args) {

        LinkedList ll = new LinkedList();
        
        ll.creatLL(10);
        ll.insertNode(2);
        ll.insertNode(12);
        ll.insertNode(1);
        ll.insertNode(5);
        ll.insertNode(9);
        ll.traverseLL();                                            // output : 10 -> 2 -> 12 -> 1 -> 5 -> 9                             
        System.out.println();

        Solution sl = new Solution();

        LinkedList l = sl.partitionAroundX(ll, 10);
        l.traverseLL();                                             // output : 9 -> 5 -> 1 -> 2 -> 10 -> 12

        

    }
}



