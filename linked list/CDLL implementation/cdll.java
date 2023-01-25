class Node {
    public int value;
    public Node next;
    public Node prev;  
}
class CircularDoublyLinkedList{
    Node head;
    Node tail;
    int size;

    public Node creationOfCDLL(int nodeValue){

        head = new Node();                                          // step-1
        Node node = new Node();

        node.value = nodeValue;                                     // step-2
        node.prev = null;
        node.next=node;                                             // note here the difference btwn dll and cdll

        head = node;                                                // step-3
        tail =node;
        size = 1;

        return head;

    }
}

public class cdll {
    public static void main(String[] args) {
        CircularDoublyLinkedList cdll = new CircularDoublyLinkedList();

        cdll.creationOfCDLL(9);
        System.out.println(cdll.head.value);
    }
}
