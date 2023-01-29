class BH{
    public int arr[];
    public int sizeOfHeap;

    public BH(int size){
        arr = new int[size+1];                                      // we will not use first cell of array so..(size+1)
        this.sizeOfHeap = 0;
        System.out.println("Binary heap has been created");
    }

    // isEmpty method

    public boolean isEmpty(){
        if (sizeOfHeap == 0) {
            return true;
        } else {
            return false;
        }
    }

    // peek operation

    public int peek(){
        if (isEmpty()) {
            System.out.println("heap is empty");
            return -1;
        } else {
            return arr[1];
        }
    }
}
public class binaryHeap {
    public static void main(String[] args) {
        BH bh = new BH(5);                                          // output : Binary heap has been created

        bh.peek();                                                  // output : heap is empty
    }
}
