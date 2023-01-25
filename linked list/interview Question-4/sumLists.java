
class Node{
    public int value;
    public Node next;
    public Node prev;
}
class LinkedList{

    Node head;
    Node tail;
    int size;

    public void creatLLA(int nodeValue){

        Node node = new Node();

        node.value = nodeValue;
        node.next = null;

        head=node;
        tail=node;
        size=1;
    }

    public void insertNode(int nodeValue){

        if (head == null) {
            creatLLA(nodeValue);
        }
        else{
            Node node = new Node();
            node.value = nodeValue;
            node.next = null;
            tail.next = node;
            tail = node;
            size++;
        }
     
    }

    public void traverseLL(){

        Node currentNode = head;
        int index = 0;

        while (index<size) {
            System.out.print(currentNode.value);

            if (currentNode.next != null) {
                System.out.print(" -> ");
            }
            currentNode = currentNode.next;
            index++;
        }
    }

}

class Solution{

    public LinkedList sumOfList(LinkedList llA , LinkedList llB){
        Node n1 = llA.head;
        Node n2 = llB.head;
        int carry = 0;

        LinkedList resultLL = new LinkedList();

        while (n1 != null || n2 != null) {
            int result = carry;

            if (n1 != null) {
                result += n1.value;
                n1 = n1.next;
            }
            if (n2 != null) {
                result += n2.value;
                n2 = n2.next;
            }
            resultLL.insertNode(result%10);
            carry = result/10; 
        }
        return resultLL;
    }

}

public class sumLists {
    public static void main(String[] args) {

        LinkedList llA = new LinkedList();
        
        llA.creatLLA(1);
        llA.insertNode(2);
        llA.insertNode(3);
        llA.insertNode(4);
        llA.traverseLL();                                          // output : 1 -> 2 -> 3 -> 4
        System.out.println();

        LinkedList llB = new LinkedList();

        llB.creatLLA(5);
        llB.insertNode(6);
        llB.insertNode(6);
        llB.insertNode(5);
        llB.traverseLL();                                          // output : 5 -> 6 -> 7 -> 6
        System.out.println();

    
        Solution sl = new Solution();
        
        LinkedList result = sl.sumOfList(llA, llB);
        result.traverseLL();                                        // output : 6 -> 8 -> 9 -> 9

    }
}



