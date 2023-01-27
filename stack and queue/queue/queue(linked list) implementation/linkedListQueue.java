class Node{
    public int value;
    public Node next;
}
class LinkedList{
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

    // deletion of node

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
        else if(location>=size-1){

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
}

class Queue{

    LinkedList list;

    public Queue(){
        list = new LinkedList();
        System.out.println("Queue is created successfully");
    }

    // isEmpty method in queue

    public boolean isEmpty(){
        if (list.head == null) {
            return true;
        } else {
            return false;
        }
    }
}

public class linkedListQueue {
    
    public static void main(String[] args) {
        
        Queue q = new Queue();                                      // output : Queue is created successfully 

        System.out.println(q.isEmpty());                            // output : true
    }
}