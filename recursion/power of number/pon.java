import java.util.*;

public class pon {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("enter base : ");
        int base = sc.nextInt();
        System.out.print("enter exponet : ");
        int expo = sc.nextInt();

        System.out.println(powerOfNumber(base , expo));
    }

    public static int powerOfNumber(int base , int expo){
        if (expo < 0) {
            return -1;
        }
        if (expo == 0) {
            return 1;
        }
        return base*powerOfNumber(base, expo-1);
    }
}
