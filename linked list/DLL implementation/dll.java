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

    // traversal in DLL

    public void traversalInDLL(){
        
        if (head == null) {
            System.out.println("LL not exist");
        } else {
            Node currentNode = head;
            int index = 0;
            while (index<size) {
                System.out.print(currentNode.value);
    
                if (currentNode.next != null) {
                    System.out.print(" <-> ");
                }
                currentNode = currentNode.next;
                index++;
            }
        }
       
    }

    // reverse traversal in DLL

    public void reverseTraversalInDLL(){
        
        if (head == null) {
            System.out.println("DLL not exist");
        }
        else{
            Node currentNode = tail;
            int index = size-1;
            while (index>=0) {
                System.out.print(currentNode.value);

                if (currentNode.prev != null) {
                    System.out.print(" <-> ");
                }
                currentNode = currentNode.prev;
                index--;

            }
        }
    }

    // searching in DLL

    public void searchingInDLL(int key){
        if (head != null) {
            Node currentNode = head;
            int index = 0;

            while (index<size) {
                if (currentNode.value == key) {
                    System.out.println(key + " found at location "+ index);
                    return;
                }
                currentNode = currentNode.next;
                index++;
            }
        }
        System.out.println("Node/LL not exist");
    }

    // deletion in DLL

    public void deletionInDLL(int location){

        if (head == null) {
            System.out.println("LL not exist");
        }
        else if (location == 0) {                                   // at the start
            
            if (size == 1) {
                head = tail = null;
                size--;
                return;
            }
            else{
                head = head.next;
                head.prev = null;
                size--;
            }
        }
        else if (location>=size-1) {                                // at the end
            
            if (size == 1) {
                head = tail = null;
                size--;
                return;
            }
            else{
                tail = tail.prev;
                tail.next = null;
                size--;
            }
        }
        else                                                        // at any position btwn start and end
        {
            Node currentNode = head;
            int index = 0;

            while (index<location-1) {
                currentNode = currentNode.next;
                index++;
            }

            Node nextNode = currentNode.next;
            currentNode.next = nextNode.next;
            nextNode.next.prev = currentNode;
            size--;
        }
    }

    // deletion of entire LL 

    public void deletionOfEntireDLL(){
        Node currNode = head.next;
        int index = 0;

        while (index<size) {
            currNode.prev = null;
            currNode = currNode.next;
            index++;
        }
        head = tail = null;
        System.out.println("Entire DLL is deleted");
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
        dll.traversalInDLL();                                       // output : 1 <-> 2 <-> 3 <-> 4 <-> 5
        System.out.println();
        dll.reverseTraversalInDLL();                                // output : 5 <-> 4 <-> 3 <-> 2 <-> 1
        System.out.println();
        dll.searchingInDLL(4);                                  // output : 4 found at location 3
        dll.deletionInDLL(3);                              // output : 1 <-> 2 <-> 3 <-> 5
        dll.traversalInDLL(); 
        System.out.println();
        dll.deletionOfEntireDLL();                                  // output : Entire DLL is delleted
        dll.traversalInDLL();                                       // output : LL not exist
  
    }
}
