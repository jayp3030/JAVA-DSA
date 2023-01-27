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

    // enqueue operation in queue

    public void enqueue(int value){
       list.insertionSinglyLL(value, list.size);
       System.out.println(value+" inserted successfully");
    }

    // dequeue operation in queue

    public int dequeue(){
        if (isEmpty()) {
            System.out.println("queue is empty");
            return -1;
        } else {
            int result = list.head.value;
            list.deletionOfNode(0);
            return result;
        }
    }

    // peek operation in queue

    public int peek(){
        if (isEmpty()) {
            System.out.println("queue is empty");
            return -1;
        } else {
            return list.head.value;
        }
    }

    // deletion of entire queue

    public void deleteQueue(){
        list.head = list.tail = null;
        System.out.println("entire queue is deleted");
    }
}

public class linkedListQueue {
    
    public static void main(String[] args) {
        
        Queue q = new Queue();                                      // output : Queue is created successfully 

        q.enqueue(10);                                              // output : 10 inserted successfully
        q.enqueue(20);                                              // output : 20 inserted successfully
        q.enqueue(30);                                              // output : 30 inserted successfully
        q.enqueue(40);                                              // output : 40 inserted successfully
        q.enqueue(50);                                              // output : 50 inserted successfully

        System.out.println(q.dequeue());                            // output : 10
        System.out.println(q.dequeue());                            // output : 20

        System.out.println(q.peek());                               // output : 30

        System.out.println(q.isEmpty());                            // output : false

        q.deleteQueue();                                            // output : entire queue is deleted
    }
}
