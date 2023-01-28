
class BinaryTree{
    String arr[];
    int lastUsedIndex;

    public BinaryTree(int size){
        arr = new String[size+1];                                   // we are not using 0th cell of array for the simplicity of node traking so.. (we do size+1)
        this.lastUsedIndex = 0;
        System.out.println("blank tree is created with size "+ size);
    }
}
public class binaryTreeArray {
    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree(6);                          // output : blank tree is created with size 6
    }
}
