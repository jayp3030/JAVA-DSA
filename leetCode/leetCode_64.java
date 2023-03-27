// Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

// Note: You can only move either down or right at any point in time.

// Example 1:
// Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
// Output: 7
// Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

// Example 2:
// Input: grid = [[1,2,3],[4,5,6]]
// Output: 12

class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length-1;
        int col = grid[0].length-1;
        return helper(grid , row , col);
    }
    private int helper(int[][] grid , int row , int col){

        if( row < 0 || col < 0 ) return Integer.MAX_VALUE;
        if( row == 0 && col == 0 ) return grid[0][0];
        return grid[row][col] + Math.min(helper(grid , row-1 , col) , helper(grid , row , col-1));
    }
}
