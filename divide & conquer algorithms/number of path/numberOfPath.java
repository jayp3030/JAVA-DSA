// problem : find number of path to reach last cell of 2D array
//           cost is given
//           you can go only in right and down from current cell not in diagonal

public class numberOfPath {

    public static int paths(int costs[][] , int row , int col , int cost){

        if (cost < 0 ) {
            return 0;
        }

        if (row == 0 && col == 0) {
            return (costs[0][0] - cost == 0) ? 1 : 0;
        }

        if (row == 0) {
            return paths(costs, 0, col-1, cost-costs[row][col]);
        }
        if (col == 0) {
            return paths(costs, row-1, 0, cost-costs[row][col]);
        }

        int pathsFromPreviousRow = paths(costs, row-1, col, cost-costs[row][col]);
        int pathsFromPreviousCol = paths(costs, row, col-1, cost-costs[row][col]);

        return pathsFromPreviousRow + pathsFromPreviousCol;
    }
    public static void main(String[] args) {
        
        int costs[][] = {
            {4,7,1,6},
            {5,7,3,9},
            {3,2,1,2},
            {7,1,6,3}
        };

        int cost = 25;

        System.out.println("Path availabe to reach last cell = "+paths(costs, costs.length-1, costs[0].length -1, cost));

        // Path availabe to reach last cell = 2
    }
}
