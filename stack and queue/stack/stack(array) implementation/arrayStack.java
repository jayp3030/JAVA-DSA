class Stack{
    int arr[];
    int top ;

    public Stack(int size){
        this.arr = new int[size];
        this.top = -1;

        System.out.println("Stack is created with the size of : "+ size);
    }

    // isEpmty method of stack

    public boolean isEmpty(){

        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    // isFull method of stack

    public boolean isFull(){

        if (top == arr.length-1) {
            return true;
        } else {
            return false;
        }
    }

    // push method in stack

    public void push(int value){

        if (isFull()) {
            System.out.println("stack is already full");
        } else {
            arr[top+1] = value;
            top++;

            System.out.println(value +" is successfully inserted");
        }
    }

    // pop method in stack

    public int pop(){

        if (isEmpty()) {
            System.out.println("stack is empty");
            return -1;
        } else {
            
            int topElement = arr[top];
            top--;

            return topElement;
        }
    }

    // peek method in stack

    public int peek(){

        if (isEmpty()) {
            System.out.println("stack is empty");
            return -1;  
        } else {
            return arr[top];
        }
    }

    // entire stack delete method

    public void deleteStack(){
        arr = null;
        System.out.println("Entire stack is deleted");
    }


}
public class arrayStack {
    public static void main(String[] args) {

        Stack s1 =new Stack(5);                                     // output : Stack is created with the size of : 5

        System.out.println(s1.isEmpty());                           // output : true     (there is no element so..)
        System.out.println(s1.isFull());                            // output : false

        s1.push(1);                                                 // output : 1 is successfully inserted 
        s1.push(2);                                                 // output : 2 is successfully inserted 
        s1.push(3);                                                 // output : 3 is successfully inserted 
        s1.push(4);                                                 // output : 4 is successfully inserted 
        s1.push(5);                                                 // output : 5 is successfully inserted 
        s1.push(6);                                                 // output : stack is already full

        System.out.println(s1.pop());                               // output : 5
        System.out.println(s1.pop());                               // output : 4

        System.out.println(s1.peek());                              // output : 3
        s1.deleteStack();                                           // output : Entire stack is deleted
    }
}
