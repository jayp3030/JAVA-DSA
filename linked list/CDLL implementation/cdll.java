class Node {
    public int value;
    public Node next;
    public Node prev;  
}
class CircularDoublyLinkedList{
    Node head;
    Node tail;
    int size;

    // creation of node in CDLL

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

    // insertion in CDLL

    public void insertionInCDLL(int nodeValue , int location){
        Node node = new Node();
        node.value = nodeValue;

        if (head == null) {                                         // if node not exist
            creationOfCDLL(nodeValue);
        }
        else if (location == 0) {                                   // insertion at start
            node.next = head;
            node.prev = tail;
            head.prev = node;
            head = node;
            tail.next = node;
        }
        else if (location>=size) {                                  // insertion at end
            node.next = head;
            node.prev = tail;
            head.prev = node;
            tail.next = node;
            tail = node;
        }
        else                                                        // insertion at any position btwn start & end
        {
            Node currentNode = head;
            int index = 0;

            while (index<location-1) {
                currentNode=currentNode.next;
                index++;
            }
            Node nextNode = currentNode.next;
            node.prev = currentNode;
            node.next = nextNode;
            currentNode.next = node;
            nextNode.prev = node;
        }
        size++;
    }

    // traversal in CDLL

    public void traversalInCDLL(){
        
        if (head == null) {
            System.out.println("LL not exist");
        } 
        else {
            Node currentNode = head;
            int index = 0;
            while (index<size) {

                System.out.print(currentNode.value);
                if (index != size-1) {
                    System.out.print(" <-> ");
                }
                currentNode = currentNode.next;
                index++;
            }
        }
      
    }

    // reverse traversal in CDLL
    
    public void reverseTraversalInCDLL(){
        
        if (head == null) {
            System.out.println("LL not exist");
        } 
        else {
            Node currentNode = tail;
            int index = size-1;
            while (index>=0) {

                System.out.print(currentNode.value);
                if (currentNode.prev != tail) {
                    System.out.print(" <-> ");
                }
                currentNode = currentNode.prev;
                index--;
            }
        }
      
    }
}

public class cdll {
    public static void main(String[] args) {
        CircularDoublyLinkedList cdll = new CircularDoublyLinkedList();

        cdll.creationOfCDLL(10);
        cdll.insertionInCDLL(9, 0);
        cdll.insertionInCDLL(11, 2);
        cdll.insertionInCDLL(12, 3);
        cdll.traversalInCDLL();                                     // output : 9 <-> 10 <-> 11 <-> 12
        System.out.println();
        cdll.reverseTraversalInCDLL();                              // output : 12 <-> 11 <-> 10 <-> 9
        
    }
}
