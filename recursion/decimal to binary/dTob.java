import java.util.*;

public class dTob {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter number to find binary : ");
        int decimal = sc.nextInt();

        System.out.println( "binary is : "+decimalToBinary(decimal));
    }

    public static int decimalToBinary(int a){
        if (a==0) {
            return 0;
        }
        return a%2 + 10*decimalToBinary(a/2);
    }
}
