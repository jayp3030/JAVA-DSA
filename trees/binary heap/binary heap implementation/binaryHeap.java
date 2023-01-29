class BH {
    public int arr[];
    public int sizeOfHeap;

    public BH(int size) {
        arr = new int[size + 1];                                    // we will not use first cell of array so..(size+1)
        this.sizeOfHeap = 0;
        System.out.println("Binary heap has been created");
    }

    // isEmpty method

    public boolean isEmpty() {
        if (sizeOfHeap == 0) {
            return true;
        } else {
            return false;
        }
    }

    // peek operation

    public int peek() {
        if (isEmpty()) {
            System.out.println("heap is empty");
            return -1;
        } else {
            return arr[1];
        }
    }

    // size of heap

    public int sizeOfBH() {
        return sizeOfHeap;
    }

    // levelOrder traversal

    public void levelOrder() {
        for (int i = 1; i <= sizeOfHeap; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // ----------------------- insertion ------------------------------------

    // heapifyBottomToTop

    public void heapifyBottomToTop(int index, String heapType) {
        int parent = index / 2;                                     // because child = 2*parent

        if (index <= 1) {                                           // root node
            return;
        }

        if (heapType == "Min") {

            if (arr[index] < arr[parent]) {
                int temp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = temp;
            }
        }

        if (heapType == "Max") {

            if (arr[index] > arr[parent]) {
                int temp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = temp;
            }
        }

        heapifyBottomToTop(parent, heapType);                       // check for all parent nodes
    }

    // insertion in binary heap

    public void insert(int nodeValue, String heapType) {
        arr[sizeOfHeap + 1] = nodeValue;
        sizeOfHeap++;
        heapifyBottomToTop(sizeOfHeap, heapType);
        System.out.println(nodeValue + " inserted successfully");
    }

    // ------------------------------deletion of root ---------------------

    // heapifyTopToBottom

    public void heapifyTopToBottom(int index, String heapType) {
        int left = index * 2;
        int right = index * 2 + 1;
        int swapNodeIndex = 0;                                          // to keep track of node to be swaped

        if (sizeOfHeap < left) {
            return;
        }

        if (heapType == "Max") {
            if (left == sizeOfHeap) {                                // means node have only one child
                if (arr[index] < arr[left]) {
                    int temp = arr[index];
                    arr[index] = arr[left];
                    arr[left] = temp;
                }
                return;
            } else { // node have two child
                if (arr[left] > arr[right]) {                       // first we found greaer from both child
                    swapNodeIndex = left;                               // and set swapNodeIndex to great child
                } else {
                    swapNodeIndex = right;
                }

                if (arr[index] < arr[swapNodeIndex]) {
                    int temp = arr[index];
                    arr[index] = arr[swapNodeIndex];
                    arr[swapNodeIndex] = temp;
                }
            }
        }

        if (heapType == "Min") {

            if (left == sizeOfHeap) {                               // means node have only one child
                if (arr[index] > arr[left]) {
                    int temp = arr[index];
                    arr[index] = arr[left];
                    arr[left] = temp;
                }
                return;
            } else {                                                // node have two child
                if (arr[right] < arr[left]) {                       // first we found smaller from both child
                    swapNodeIndex = right;                              // and set swapNodeIndex to small child
                } else {
                    swapNodeIndex = left;
                }

                if (arr[index] > arr[swapNodeIndex]) {
                    int temp = arr[index];
                    arr[index] = arr[swapNodeIndex];
                    arr[swapNodeIndex] = temp;
                }
            }
        }

        heapifyTopToBottom(swapNodeIndex, heapType);                    // we wil check for all child node

    }

    // delete root of BH

    public int deleteRootOfBH(String heapType){
        if (isEmpty()) {
            return -1;
        } else {
            int deletedVal = arr[1];
            arr[1] = arr[sizeOfHeap];                               // swaped last node of heap with root
            sizeOfHeap--;                                           // size is decreased so last node is deleted

            heapifyTopToBottom(1, heapType);
            return deletedVal;
        }
    }

    // deletion of entire BH

    public void deletionOfBH(){
        arr = null;
        System.out.println("entire BH is deleted");
    }
}

public class binaryHeap {
    public static void main(String[] args) {
        BH bh = new BH(5);                                          // output : Binary heap has been created

        bh.insert(10, "Max");                                       // output : 10 inserted successfully
        bh.insert(20, "Max");                                       // output : 20 inserted successfully
        bh.insert(30, "Max");                                       // output : 30 inserted successfully
        bh.insert(40, "Max");                                       // output : 40 inserted successfully
        bh.insert(50, "Max");                                       // output : 50 inserted successfully

        bh.levelOrder();                                            // output : 50 40 20 10 30 (before deletion)
        System.out.println(bh.peek());                              // output : 50

        bh.deleteRootOfBH("Max");
        bh.levelOrder();                                            // output : 40 30 20 10 (after deletion)

        bh.deletionOfBH();                                          // output : entire BH is deleted

    }
}
