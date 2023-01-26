class Stack{
    int arr[];
    int top ;

    public Stack(int size){
        this.arr = new int[size];
        this.top = -1;

        System.out.println("Stack is created with the size of : "+ size);
    }

    public boolean isEmpty(){

        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }
}
public class arrayStack {
    public static void main(String[] args) {

        Stack s1 =new Stack(5);                                     // output : Stack is created with the size of : 5

        System.out.println(s1.isEmpty());                           // output : true     (there is no element so..)
    }
}
