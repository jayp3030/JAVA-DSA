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
    }
}
