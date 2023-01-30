class BinaryNode{
    public int value;
    public int height;
    public BinaryNode left;
    public BinaryNode right;
}
class AVL{

    BinaryNode root;

    public AVL(){
        root = null;
        System.out.println("AVL tree created successfully");
    }
}
public class avlTree {
    public static void main(String[] args) {
        
        AVL at = new AVL();                                         // output : AVL tree created successfully
    }
}
