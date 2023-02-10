
public class fibonacci {

    public static int Fibo(int n){

        if (n < 1) {
            return -1;
        } else if (n == 1) {
            return 0;
        }else if (n == 2) {
            return 1;
        }else{
            return Fibo(n-1) + Fibo(n-2);
        }
    }
    public static void main(String[] args) {
        
        int n = 7;
        int res = Fibo(n);

        System.out.println("fibonacci number at position "+n+" is = "+res);

        // output : fibonacci number at position 7 is = 8
    }
}
