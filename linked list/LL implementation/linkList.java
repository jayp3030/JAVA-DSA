class Node{
    public int value;
    public Node next;
}
class SinglyLinkedList{
    public Node head;
    public Node tail;
    public int size;

    // creation method of linkList

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

    // insertion method of linkList

    public void insertionSinglyLL(int nodeValue , int location){
        Node node = new Node();
        node.value=nodeValue;

        if (head == null) {                                         // if LL is blank
            createSinglyLinkList(nodeValue);   
        }else if(location == 0){                                    // insertion at beginning of LL
            node.next = head;
            head = node;
        }else if(location >= size){                                 // insertion at end of LL
            node.next = null;
            tail.next = node;
            tail = node;
        }else{                                                      // insertion at any location btwn beginning and end

            Node currentNode = head;
            int index = 0;

            while (index < location-1) {                            // traverse to the location 
                currentNode = currentNode.next;
                index++;    
            }

            Node nextNode = currentNode.next;
            currentNode.next = node;
            node.next = nextNode;

        }
        size++ ;                                                    // because we add new node after each time we call function
    }
}
public class linkList{
    public static void main(String[] args) {
        SinglyLinkedList sLL = new SinglyLinkedList();

        sLL.createSinglyLinkList(7);
        sLL.insertionSinglyLL(10, 0);
        sLL.insertionSinglyLL(12, 3);

        System.out.print(sLL.head.value);
    }
}