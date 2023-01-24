class Node{
    public int value;
    public Node next;
}
class CircularSinglyLinkedList{
   public Node head;
   public Node tail;
   public int size;

   // creation of CSLL

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

   // insertion in CSLL

   public void insertionInCSLL(int nodeValue , int location){
    
    Node node = new Node();
    node.value = nodeValue;


    if (head == null) {                                             // if LL not exist
        createCSLL(nodeValue);
    }
    else if (location == 0) {                                       // at the beginning of LL                                  
        node.next = head;
        head = node;
        tail.next = node;
    }
    else if (location>=size) {                                       // at the end of LL
        node.next = tail.next;
        tail.next = node;
        tail = node;

    }
    else{                                                           // at specified location in LL
        Node currentNode = head;
        int index = 0;

        while(index<location){
            currentNode = currentNode.next;
            index++;
        }

        Node nexNode = currentNode.next;
        node.next = nexNode;
        currentNode.next = node;
    }
    size++;
   }
}

public class csll {
    public static void main(String[] args) {

        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();

        csll.createCSLL(5);
        csll.insertionInCSLL(6, 0);
        csll.insertionInCSLL(7, 2);
        csll.insertionInCSLL(8, 3);                                 // output : 6 5 7 8
         
    }
}
