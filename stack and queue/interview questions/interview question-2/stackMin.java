// problem : find min in stack with o(1) time/space complexity

// solution:

class Node{
    int value;
    Node next;

    public Node(int value , Node next){
        this.value = value;
        this.next = next;
    }
}

class Stack{
    Node top;
    Node min;

    public Stack(){
        top = null;
        min = null;
    }

    public int min(){
        return min.value;
    }

    // push

    public void push(int  value){

        if (min == null) {
            min =new Node(value, min);
        } else if (min.value < value) {
            min = new Node(min.value, min);
        }
        else{
            min = new Node(value, min);
        }
        top =new Node(value, top);
    }

    // pop

    public int pop(){
        min = min.next;
        int result = top.value;
        top = top.next;
        return result;
    }
}

public class stackMin {
    public static void main(String[] args) {
        
        Stack s =new Stack();

        s.push(5);
        System.out.println(s.min());                                // output : 5

        s.push(3);
        s.push(4);
        s.push(2);
        System.out.println(s.min());                                // output : 2

        s.pop();
        System.out.println(s.min());                                // output : 3

    }

}
