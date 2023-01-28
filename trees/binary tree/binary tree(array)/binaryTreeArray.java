
class BinaryTree{
    String arr[];
    int lastUsedIndex;

    public BinaryTree(int size){
        arr = new String[size+1];                                   // we are not using 0th cell of array for the simplicity of node traking so.. (we do size+1)
        this.lastUsedIndex = 0;
        System.out.println("blank tree is created with size "+ size);
    }

    // isFUll method

    public boolean isFull(){
        if (lastUsedIndex == arr.length-1) {
            return true;
        } else {
            return false;
        }
    }

    // insertion of node

    public void insert(String nodeValue){
        if (!isFull()) {
            arr[lastUsedIndex+1] = nodeValue;
            lastUsedIndex++;
            System.out.println(nodeValue + " inserted successfully");
        } else {
            System.out.println("the BT is full");
        }
    }

    // preOrder traversal 

    public void preOrder(int index){
        if (index > lastUsedIndex) {
            return;
        }
        System.out.print(arr[index] + " ");
        preOrder(index * 2);
        preOrder(index * 2 + 1);
    }

    // inOrder traversal

    public void inOrder(int index){
        if (index > lastUsedIndex) {
            return;
        }
        inOrder(index*2);
        System.out.print(arr[index] + " ");
        inOrder(index*2+1);
    }

    // postOrder traversal

    public void postOrder(int index){
        if (index > lastUsedIndex) {
            return;
        }
        postOrder(index*2);
        postOrder(index*2 + 1);
        System.out.print(arr[index] + " ");
    }

    // levelOrder traversal (simply traverse the array)

    public void levelOrder(){
        for (int i = 1; i <= lastUsedIndex; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // searching in binary tree

    public int search(String key){
        for (int i = 1; i < lastUsedIndex; i++) {
            if (arr[i] == key) {
                System.out.println(key +" fount at index "+i);
                return i;
            }  
        }
        System.out.println(key + " does not exist in binary tree");
        return -1;
    }
}
public class binaryTreeArray {
    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree(6);                          // output : blank tree is created with size 6

        bt.insert("N1");                                            // output : N1 inserted successfully
        bt.insert("N2");                                            // output : N2 inserted successfully
        bt.insert("N3");                                            // output : N3 inserted successfully
        bt.insert("N4");                                            // output : N4 inserted successfully
        bt.insert("N5");                                            // output : N5 inserted successfully
        bt.insert("N6");                                            // output : N6 inserted successfully
        bt.insert("N7");                                            // output : the BT is full

        bt.preOrder(1);                                             // output : N1 N2 N4 N5 N3 N6
        System.out.println();
        bt.inOrder(1);                                             // output : N4 N2 N5 N1 N6 N3
        System.out.println();
        bt.postOrder(1);                                            // output : N4 N5 N2 N6 N3 N1
        System.out.println();
        bt.levelOrder();                                            // output : N1 N2 N3 N4 N5 N6
        System.out.println();

        bt.search("N3");                                            // output : N3 found at index 3
        bt.search("N7");                                            // output : N7 does not exist in binary tree
    }
}
