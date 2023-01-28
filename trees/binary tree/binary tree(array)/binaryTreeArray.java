
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
    }
}
