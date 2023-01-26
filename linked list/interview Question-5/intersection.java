
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

    public Node findKThNode(Node head , int k){                     // if two linked list has different size then this method return the start node of longer list.

        Node currentNode = head;

        while (k>0 && currentNode != null) {
            currentNode = currentNode.next;
            k--;
        }
        return currentNode;
        
    }

    public void addSameNode(LinkedList lla , LinkedList llb , int nodeValue){           // this mehod insert same node of two ll at the end of ll.

        Node node = new Node();
        node.value = nodeValue;

        lla.tail.next = node;
        lla.tail = node;

        llb.tail.next = node;
        llb.tail = node;

    }

    public Node findIntersectNode(LinkedList ll1 , LinkedList ll2){

        if(ll1.head == null || ll2.head == null) return null;

        if (ll1.tail != ll2.tail) {
            return null;
        }

        Node longer = new Node();
        Node shorter = new Node();

        if (ll1.size > ll2.size) {
            longer = ll1.head;
            shorter = ll2.head;
        }
        else
        {
            longer = ll2.head;
            shorter = ll1.head;
        }

        longer=findKThNode(longer, Math.abs(ll1.size - ll2.size));

        while (longer != shorter) {
            longer =longer.next;
            shorter =shorter.next;
        }

        return longer;
    }

}

public class intersection {
    public static void main(String[] args) {

        LinkedList llA = new LinkedList();
        
        llA.creatLLA(1);
        llA.insertNode(2);
        llA.insertNode(3);
        llA.insertNode(4);
    

        LinkedList llB = new LinkedList();

        llB.creatLLA(5);
        llB.insertNode(6);
        llB.insertNode(7);
      

    
        Solution sl = new Solution();

        sl.addSameNode(llA, llB, 11);
        sl.addSameNode(llA, llB, 12);                               
        sl.addSameNode(llA, llB, 13);                               


        // ll1 - 1 -> 2 -> 3 -> 4 -> 11 -> 12 -> 13
        // ll2 - 5 -> 6 -> 7 -> 11 -> 12 -> 13

        Node intsectNode = sl.findIntersectNode(llA, llB);
        System.out.println(intsectNode.value);                      // output : 11
        

    }
}




