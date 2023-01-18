import java.util.*;

public class sod {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number to find sum of digits : ");
        int n = sc.nextInt();

        System.out.println(sumOfDigit(n));
    }
    public static int sumOfDigit(int n){
       
        if (n==0 || n<0) {
            return 0;
        }

        return n%10 + sumOfDigit(n/10);
    }
}
