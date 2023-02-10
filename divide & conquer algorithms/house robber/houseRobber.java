// problem :

// N house are given
// robber can not rob adjacent houses
// find the max amount robbed by robber

public class houseRobber {
    public static int maxMoneyRobbed(int housesNetworth [] , int currentIndex){

        if (currentIndex >= housesNetworth.length) {
            return 0;
        }

        int stealCurrentHouse = housesNetworth[currentIndex] + maxMoneyRobbed(housesNetworth, currentIndex+2);
        int skipCurrentHouse = maxMoneyRobbed(housesNetworth, currentIndex+1);

        return Math.max(stealCurrentHouse, skipCurrentHouse);
    }
    public static void main(String[] args) {
        
        int []housesNetworth = {6,7,1,30,8,2,4};

        System.out.println("max amount robber by robber is = "+maxMoneyRobbed(housesNetworth, 0));

        // output : max amount robber by robber is = 41
    }
}
