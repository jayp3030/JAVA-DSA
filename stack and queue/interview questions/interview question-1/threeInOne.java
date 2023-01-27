// problem : how to implement three stacks in a single array

// solution :

class ThreeStack{

    public int numOfStack = 3;
    public int stackCapacity;                                       // capacity of each stack
    public int values[];                                            // this array has data values of each stack
    public int currentSizes [];                                            // this array keep track of size of each stacks

    public ThreeStack(int stackSize){

        stackCapacity = stackSize;
        values = new int[stackCapacity * numOfStack];
        currentSizes = new int [numOfStack];
        
    }

    // isFull 

    public boolean isFull(int stackNum){
        if (currentSizes[stackNum] == stackCapacity) {
            return true;
        } else {
            return false;
        }
    }

    // isEmpty

    public boolean isEmpty(int stackNum){

        if (currentSizes[stackNum] == 0) {
            return true;
        } else {
            return false;
        }
    }

    // indexOfTop element 

    public int indexOfTop(int stackNum){
        int size = currentSizes[stackNum];
        int offSet = stackNum * stackCapacity;

        return offSet+size-1;
    }

    // push operation

    public void push(int stackNum , int value){
        if (isFull(stackNum)) {
            System.out.println("stack is full");
        } else {
            currentSizes[stackNum]++;
            values[indexOfTop(stackNum)] = value;
            System.out.println(value + " inserted successfully in " +(stackNum+1));
        }
    }

    // pop operation

    public int pop(int stackNum){
        if (isEmpty(stackNum)) {
            System.out.println("stack is empty");
            return -1;
        } else {
            int top = indexOfTop(stackNum);
            int result = values[top];
            values[top] = 0;
            currentSizes[stackNum]--;
            return result;
        }
    }

    // peek operation

    public int peek(int stackNum){
        if (isEmpty(stackNum)) {
            System.out.println("stack is empty");
            return -1;
        } else {
            return values[indexOfTop(stackNum)];
        }
    }

}

public class threeInOne {
    public static void main(String[] args) {
        
        ThreeStack newStack = new ThreeStack(3);

        // sack 1
        newStack.push(0, 10);                                       // output : 10 inserted successfully 1
        newStack.push(0, 20);                                       // output : 20 inserted successfully 1
        newStack.push(0, 30);                                       // output : 30 inserted successfully 1

        System.out.println(newStack.pop(0));                        // output : 30
        System.out.println(newStack.peek(0));                        // output : 20

        System.out.println(newStack.isEmpty(0));                    // output : false
        System.out.println(newStack.isFull(0));                    // output : false


        // stack 2
        newStack.push(1, 100);                                       // output : 10 inserted successfully 2
        newStack.push(1, 200);                                       // output : 20 inserted successfully 2
        newStack.push(1, 300);                                       // output : 30 inserted successfully 2

        System.out.println(newStack.pop(1));                        // output : 300
        System.out.println(newStack.peek(1));                        // output : 200

        System.out.println(newStack.isEmpty(1));                    // output : false
        System.out.println(newStack.isFull(1));                    // output : false

        // stack 3
        newStack.push(2, 1000);                                       // output : 10 inserted successfully 3
        newStack.push(2, 2000);                                       // output : 20 inserted successfully 3
        newStack.push(2, 3000);                                       // output : 30 inserted successfully 3

        System.out.println(newStack.pop(2));                        // output : 3000
        System.out.println(newStack.peek(2));                        // output : 2000

        System.out.println(newStack.isEmpty(2));                    // output : false
        System.out.println(newStack.isFull(2));                    // output : false


    }
}
