class Node{
    public int value;
    public Node next;
}
class CircularSinglyLinkedList{
   public Node head;
   public Node tail;
   public int size;

   public Node createCSLL(int nodeValue){

    head = new Node();

    Node node = new Node();
    node.value = nodeValue;
    node.next = node;

    head =node;
    tail=node;
    size=1;
    return head;
   }
}

public class csll {
    public static void main(String[] args) {

        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();

        csll.createCSLL(5);
        System.out.println(csll.head.value);
        
    }
}
