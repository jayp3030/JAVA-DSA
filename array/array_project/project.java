import java.util.*;

public class project {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.print("How many days temprature ? ");
        int n =sc.nextInt();
        float arr []= new float[n];

        double sum=0;
        for (int i = 0; i < arr.length; i++) {
                System.out.print((i+1) + " days' temprature : ");
                arr[i] = sc.nextFloat(); 
                sum+=arr[i];           
        }

        double avrg = sum/arr.length;
        System.out.println("Average = "+avrg);

        int days = 0;
        for (int i = 0; i < arr.length; i++) {
            
            if (arr[i]>avrg) {
                days+=1;
            }
        }
        System.out.print(days+" days' are above average");
        
    }
}
