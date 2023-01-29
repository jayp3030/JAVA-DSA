class BH{
    public int arr[];
    public int sizeOfHeap;

    public BH(int size){
        arr = new int[size+1];
        this.sizeOfHeap = 0;
        System.out.println("Binary heap has been created");
    }
}
public class binaryHeap {
    public static void main(String[] args) {
        BH bh = new BH(5);                                          // output : Binary heap has been created
    }
}
