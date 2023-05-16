// You are given an m x n grid where each cell can have one of three values:

// 0 representing an empty cell,
// 1 representing a fresh orange, or
// 2 representing a rotten orange.
// Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

// Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

// Example 1:
// Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
// Output: 4

// Example 2:
// Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
// Output: -1
// Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

// Example 3:
// Input: grid = [[0,2]]
// Output: 0
// Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.

class Solution {
    static class Pair{
        int x;
        int y;

        Pair(int x , int y){
            this.x = x;
            this.y = y;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int total = 0;
        int rotten = 0;
        int time = 0;

        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 1 || grid[i][j] == 2) total++;
                if(grid[i][j] == 2) q.add(new Pair(i , j));
            }
        }

        if(total == 0) return 0;
        while(!q.isEmpty()){
            int size = q.size();
            rotten += size;
            if(rotten == total) return time;

            time++;

            for(int i = 0 ; i < size ; i++){
                Pair p = q.remove();

                if(p.x + 1 < grid.length && grid[p.x+1][p.y] == 1){
                    grid[p.x+1][p.y] = 2;
                    q.add(new Pair(p.x+1,p.y));
                }
                if(p.x - 1 >= 0 && grid[p.x - 1][p.y] == 1){
                    grid[p.x - 1][p.y] = 2;
                    q.add( new Pair(p.x - 1,p.y));
                }
                if(p.y + 1 < grid[0].length && grid[p.x][p.y+1] == 1){
                    grid[p.x][p.y+1] = 2;
                    q.add(new Pair(p.x,p.y+1));
                }
                if(p.y - 1 >= 0  && grid[p.x][p.y - 1] == 1){
                    grid[p.x][p.y - 1] = 2;
                    q.add(new Pair(p.x,p.y - 1));
                }
            }
        }
        return -1;
    }
}