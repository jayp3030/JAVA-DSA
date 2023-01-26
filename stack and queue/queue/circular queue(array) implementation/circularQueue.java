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
}
public class circularQueue {
    public static void main(String[] args) {
        
        CQ cq1 = new CQ(5);                                         // output : CQ is successfully created with size : 5
    }
}
