class CQ{
    int arr [];
    int beginningOfQueue ;
    int top ;
    int size ;

    public CQ(int size){
        this.arr = new int[size];
        this.size = size;
        this.top = -1;
        this.beginningOfQueue = -1;

        System.out.println("CQ is successfully created with size : " + size);
    }

    // isEmpty method in CQ

    public boolean isEmpty(){
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    // isFull method in CQ

    public boolean isFull(){
        if (top+1 == beginningOfQueue) {
            return true;
        } 
        else if (beginningOfQueue == 0 && top == size-1) {
            return true;
        }
        else {
            return false;
        }
    }

    // enqueue operation in CQ

    public void enqueue(int value){

        if (isFull()) {
            System.out.println("CQ is already full");
        }
        else if (isEmpty()) {
            beginningOfQueue = 0;
            top ++;
            arr[top] = value;
            System.out.println(value + " inserted successfully");
        }
         else {
            if (top+1 == size) {
                top = 0;    
            }else{
                top++;
            }
            arr[top] = value;
            System.out.println(value + " inserted successfully");
        }
    }

    // dequeue operation in CQ

    public int dequeue(){
        if (isEmpty()) {
            System.out.println("CQ is already empty");
            return -1;
        }
        else{

            int result = arr[beginningOfQueue];
            arr[beginningOfQueue] = 0;

            if (beginningOfQueue == top) {
                beginningOfQueue = top = -1;
            } else if (beginningOfQueue+1 == size) {
                beginningOfQueue =0;
            }
            else {
               beginningOfQueue++; 
            }
            return result;
        }
    }

    // peek operation CQ

    public int peek(){
        if (isEmpty()) {
            System.out.println("CQ is empty");
            return -1;
        } else {
            return arr[beginningOfQueue];
        }
    }

    // delete entire CQ

    public void deleteQUeue(){
        arr =null;
        System.out.println("entire queue is deleted");
    }
}
public class circularQueue {
    public static void main(String[] args) {
        
        CQ cq1 = new CQ(5);                                         // output : CQ is successfully created with size : 5

        cq1.enqueue(10);                                            // output : 10 inserted successfully
        cq1.enqueue(20);                                            // output : 20 inserted successfully
        cq1.enqueue(30);                                            // output : 30 inserted successfully
        cq1.enqueue(40);                                            // output : 40 inserted successfully
        cq1.enqueue(50);                                            // output : 50 inserted successfully

        System.out.println(cq1.isEmpty());                          // output : false
        System.out.println(cq1.isFull());                           // output : true

        System.out.println(cq1.dequeue());                           // output : 10
        System.out.println(cq1.dequeue());                           // output : 20

        System.out.println(cq1.peek());                             // output : 30

        cq1.deleteQUeue();                                          // output : entire queue is deleted 

    }
}
