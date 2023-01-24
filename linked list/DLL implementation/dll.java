class Node {
    public int value;
    public Node next;
    public Node prev ;
}
class DoublyLinkedList{
    public Node head;
    public Node tail;
    public int size;

    public Node creationOfNodeInDLL(int nodeValue){

        head = new Node();
        Node node = new Node();

        node.value = nodeValue;
        node.prev = null;
        node.next = null;

        head = node;
        tail = node;
        size=1;
        return head;

    }
}

public class dll {
    public static void main(String[] args) {
        
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.creationOfNodeInDLL(5);
        System.out.println(dll.head.value);
        
    }
}
