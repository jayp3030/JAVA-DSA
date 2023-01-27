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
class Stack{

    LinkedList linkList;

    public Stack(){                                                
        linkList = new LinkedList();                              
    }

    // push operation on stack

    public void push(int value){
        linkList.insertionSinglyLL(value, 0);
        System.out.println(value + " inserted in stack");
    }

    // isEmpty method in stack

    public boolean isEmpty(){
        if (linkList.head == null) {
            System.out.println("stack is empty");
            return true;
        } else {
            return false;
        }
    }

    // pop operation in stack

    public int pop(){

        int result = -1;

        if (isEmpty()) {
            System.out.println("stack is empty");
        } else {
           result = linkList.head.value;
           linkList.deletionOfNode(0);
        }
        return result;
    }

    // peek operation in stack

    public int peek(){

        if (isEmpty()) {
            System.out.println("stack is empty");
            return -1;
        } else {
           return linkList.head.value;
        }
    }

    // deletion of entire stack

    public void deleteStack(){
        linkList.head = null;
        System.out.println("stack is deleted");

    }


}
public class linkedListStack {
    public static void main(String[] args) {
        
        Stack s1 = new Stack();                                     // creation of stack

        s1.push(1);                                                 // 1 inserted to stack
        s1.push(2);                                                 // 2 inserted to stack
        s1.push(3);                                                 // 3 inserted to stack
        s1.push(4);                                                 // 4 inserted to stack
        s1.push(5);                                                 // 5 inserted to stack

        System.out.println(s1.isEmpty());                           // output : false

        System.out.println(s1.pop());                               // output : 5
        System.out.println(s1.pop());                               // output : 4

        System.out.println(s1.peek());                              // output : 3
        s1.deleteStack();                                           // output : stack is deleted
    }
}
