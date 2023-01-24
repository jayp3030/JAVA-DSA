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

    // traversal method of singly LL

    public void traversalSinglyLL(){
        Node currentNode = head;
        int index = 0;

        if (head == null) {
            System.out.println("LL not exist");                     // if LL is blank
        }

        while(index < size){
            System.out.print(currentNode.value);
            if (currentNode.next != null) {                         // for arrow between value
                System.out.print(" -> ");
            }
            currentNode = currentNode.next;
            index++;
        }
    }

    // searching in singly LL

    public void searchInLL(int key){
        Node currentNode = head;
        int index = 0;

        if (head != null) {
            while (index<size) {
                if (currentNode.value == key ) {
                    System.out.println(currentNode.value + " found at location "+ index );
                    return;
                }
                currentNode = currentNode.next;
                index++;
            }
        }
        System.out.println("Node not found");     
    }

    // deletion in singly LL

    public void deletionOfNode(int location){
        if (head == null) {
            System.out.println("SLL not exist");
            return;
        }else if(location == 0){
            head = head.next;
            size--;

            if (size==1) {
                tail=null;
            }
        }
        else if(location>=size){

            if (size == 1) {
                head =null;
                tail = null;
                size--;
                return;
            }
            else{
                Node currentNode = head;
                int index = 0;

                while(index<size-1){
                    currentNode = currentNode.next;
                    index++;
                }
                currentNode.next = null;
                tail = currentNode;
                size--;
            }
        }else {
            Node currentNode = head;
            int index = 0;
            while(index<location-1){
                currentNode = currentNode.next;
                index++;
            }
            Node nextNode = currentNode.next;
            currentNode.next = nextNode.next;
            size--;
        }
    }

    // deletion of entire SLL

    public void deleteEntireSLL(){
        head = tail = null;
        System.out.println("Entrire SLL deleted");
    }
}
public class sll{
    public static void main(String[] args) {
        SinglyLinkedList sLL = new SinglyLinkedList();

        sLL.createSinglyLinkList(7);
        sLL.insertionSinglyLL(6, 0);
        sLL.insertionSinglyLL(8, 2);
        sLL.insertionSinglyLL(9, 3);
        sLL.insertionSinglyLL(10, 4);
        sLL.traversalSinglyLL();      
        System.out.println();                                            // output : 6 -> 7 -> 8 -> 9 -> 10
        sLL.searchInLL(10);                                         // output : 10 found at location 4
        sLL.deletionOfNode(2);                                 // output :  6 -> 7 -> 9 -> 10
        sLL.traversalSinglyLL();           
        sLL.deleteEntireSLL();
                                           
    }
}