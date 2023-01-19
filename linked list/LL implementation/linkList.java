class Node{
    public int value;
    public Node next;
}
class SinglyLinkedList{
    public Node head;
    public Node tail;
    public int size;

    public Node createSinglyLinkList(int nodeValue){
        head = new Node();
        Node node = new Node();
        node.value = nodeValue;
        node.next = null;
        head=node;
        tail=node;
        size = 1;

        return head;
    }
}
public class linkList{
    public static void main(String[] args) {
        SinglyLinkedList sLL = new SinglyLinkedList();

        sLL.createSinglyLinkList(7);

        System.out.print(sLL.head.value);
    }
}