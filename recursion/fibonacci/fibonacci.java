import java.util.*;

public class fibonacci {
    public static void main(String args[]){

        Scanner sc =new Scanner(System.in);
        System.out.print("Enter index to find the fibonacci number : ");
        int n =sc.nextInt();

        System.out.println(fibo(n));
    }

    public static int fibo(int n){
        if (n<0) {
            return -1;
        }
        if (n==0 || n==1) {
            return n;
        }
        return fibo(n-1)+fibo(n-2);
    }
}
