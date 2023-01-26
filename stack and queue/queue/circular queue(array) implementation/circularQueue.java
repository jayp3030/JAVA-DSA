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
        else if (beginningOfQueue == -1 && top == size-1) {
            return true;
        }
        else {
            return false;
        }
    }
}
public class circularQueue {
    public static void main(String[] args) {
        
        CQ cq1 = new CQ(5);                                         // output : CQ is successfully created with size : 5

        System.out.println(cq1.isEmpty());                          // output : true
        System.out.println(cq1.isFull());                           // output : false
    }
}
