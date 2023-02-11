// problem : find minimum cost to reach last cell of 2D costsay from [0][0]
//           you can go only in right and down  not in diagonal

public class mCLC {

    public static int minCost(int costs[][] , int row , int col){

        if (row == -1 || col == -1) {
            return Integer.MAX_VALUE;
        }
        if (row == 0 && col== 0) {
            return costs[row][col];
        }

        int minCost1 = minCost(costs, row, col-1);
        int minCost2 = minCost(costs, row-1, col);

        int minimumCost =  Math.min(minCost1, minCost2);

        return minimumCost + costs[row][col];                       // include last cell cost also
    }
    public static void main(String[] args) {
        
        int costs [][] = {

            {4 , 7 , 8 , 6 , 4},
            {6 , 7 , 3 , 9 , 2 },
            {3 , 8 , 1 , 2 , 4 },
            {7 , 1 , 7 , 3 , 7 },
            {2 , 9 , 8 , 9 , 3}
        };

        System.out.println("Minimus cost to reach last cell = "+minCost(costs, costs.length-1, costs[0].length -1));

        // Minimus cost to reach last cell = 36
    }
}
