// problem : implement queue class which implements queue using two stacks

// solution :

import java.util.Stack;
class QviaS{
    Stack <Integer> stack1;
    Stack <Integer> stack2;

    public QviaS(){
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    // size of queue

    public int size(){
        int res = stack1.size() + stack2.size();
        return res;
    }

    // enqueue

    public void enqueue(int value){
        stack1.push(value);
    }

    // shift element to stack1 to stack2

    public void shift(){
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                int popOutElement = stack1.pop();
                stack2.push(popOutElement);                         // pop out element of s1 and push to s2
            }
        } 
    }

    // dequeue

    public int dequeue(){
        shift();
        return stack2.pop();
    }

    // peek

    public int peek(){
        shift();
        return stack2.peek();
    }
    
}

public class queueViaStack {
    public static void main(String[] args) {
        
        QviaS q = new QviaS();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);

        System.out.println(q.size());                               // output : 4
        System.out.println(q.dequeue());                               // output : 10
        System.out.println(q.peek());                               // output : 20
    }
}
