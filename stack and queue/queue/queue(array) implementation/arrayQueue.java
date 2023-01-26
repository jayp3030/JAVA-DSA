class Queue{
    int arr[];
    int beginningOfQueue ;
    int top ;

    public Queue(int size){
        this.arr = new int[size];
        this.beginningOfQueue = -1;
        this.top = -1;
        System.out.println("queue is created with size : "+ size);
    }

    // isEmpty method in queue

    public boolean isEmpty(){

        if (beginningOfQueue == -1 || beginningOfQueue == arr.length) {
            return true;
        } else {
            return false;
        }
    }

    // isFull method in queue

    public boolean isFull(){

        if (top == arr.length-1) {
            return true;
        } else {
            return false;
        }
    }

    // enque operation in queue

    public void enqueue(int value){
        if (isFull()) {
            System.out.println("queue is already full");
        }
        else if (isEmpty()) {
            beginningOfQueue = 0;
            top++;
            arr[top] = value;
            System.out.println(value +" inserted successfully");
        }
        else
        {
            top++;
            arr[top] = value;
            System.out.println(value +" inserted successfully");
        }
    }
    
}
public class arrayQueue {
    public static void main(String[] args) {

        Queue q1 = new Queue(5);                                    // output : queue is created with size : 5

        q1.enqueue(10);                                             // output : 10 inserted successfully
        q1.enqueue(20);                                             // output : 20 inserted successfully
        q1.enqueue(30);                                             // output : 30 inserted successfully
        q1.enqueue(40);                                             // output : 40 inserted successfully
        q1.enqueue(50);                                             // output : 50 inserted successfully

        System.out.println(q1.isEmpty());                           // output : false
        System.out.println(q1.isFull());                            // output : true                    
        
    }
}
