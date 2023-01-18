import java.util.*;


public class gcd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter number A:");
        int a = sc.nextInt();
        System.out.print("enter number B : ");
        int b =sc.nextInt();

        System.out.println(greatestCommonDivisor(a,b));
    }

    public static int greatestCommonDivisor(int a ,int b){
        if (a<0 || b<0) {
            return -1;
        }
        if (b==0) {
            return a;   
        }
        return greatestCommonDivisor(b, a%b);
    }
}
