class Stack{
    int arr[];
    int top ;

    public Stack(int size){
        this.arr = new int[size];
        this.top = -1;

        System.out.println("Stack is created with the size of : "+ size);
    }
}
public class arrayStack {
    public static void main(String[] args) {

        Stack s1 =new Stack(5);

    }
}
