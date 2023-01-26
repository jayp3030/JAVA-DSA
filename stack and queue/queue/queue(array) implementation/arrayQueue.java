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
}
public class arrayQueue {
    public static void main(String[] args) {

        Queue q1 = new Queue(5);                                    // output : queue is created with size : 5
        
    }
}
