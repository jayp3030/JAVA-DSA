class Node {
    public int value;
    public Node next;
    public Node prev ;
}
class DoublyLinkedList{
    public Node head;
    public Node tail;
    public int size;

    // creation of node in DLL

    public Node creationOfNodeInDLL(int nodeValue){

        head = new Node();                                          // step-1
        Node node = new Node();

        node.value = nodeValue;                                     // step-2
        node.prev = null;
        node.next = null;

        head = node;                                                // step-3
        tail = node;
        size=1;
        return head;

    }

    // insertion of node in DLL

    public void insertionInDLL(int nodeValue , int location){
        Node node = new Node();
        node.value = nodeValue;

        if (head == null) {
            creationOfNodeInDLL(nodeValue);
        }
        else if (location == 0) {                                   // at the beginning
            head.prev = node;
            node.next = head;
            node.prev =null;
            head = node;
        }
        else if (location>=size) {                                  // at the end
            node.prev = tail;
            node.next = null;
            tail.next = node;
            tail = node;
        }
        else{                                                       // at any location btwn start and end
            Node currentNode = head;
            int index = 0;

            while (index<location-1) {
                currentNode = currentNode.next;
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
}

public class dll {
    public static void main(String[] args) {
        
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.creationOfNodeInDLL(2);
        dll.insertionInDLL(1, 0);
        dll.insertionInDLL(3, 2);
        dll.insertionInDLL(4, 3);
        dll.insertionInDLL(5, 4);
        System.out.println(dll.head.value);
        
    }
}
