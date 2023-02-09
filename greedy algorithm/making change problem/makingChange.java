import java.util.*;

class MCP{

    static void makeChangeProblem(int []coins , int N){             // N = amount to be given

        Arrays.sort(coins);
        int index = coins.length-1;                                 // last element of array (biggest coin)

        while (true) {
            
            int coinValue = coins[index];
            index--;
            int maxAmount = (N/coinValue)*coinValue;

            if (maxAmount > 0) {
                System.out.println("Coin value : "+ coinValue+"  used coin : "+(N/coinValue));
                N=N-maxAmount;
            }

            if (N == 0) {
                break;   
            }
        }
    }
}
public class makingChange {
    public static void main(String[] args) {
        
        int []coins = {1,2,5,10,20,50,100,1000};
        int amount = 2035;

        System.out.println("coins available : " + Arrays.toString(coins));
        System.out.println("Amount to be changed : "+amount);

        MCP.makeChangeProblem(coins, amount);

        // output 

        // coins available : [1, 2, 5, 10, 20, 50, 100, 1000]

        // Amount to be changed : 2035

        // Coin value : 1000  used coin : 2
        // Coin value : 20  used coin : 1
        // Coin value : 10  used coin : 1
        // Coin value : 5  used coin : 1
    }
}
