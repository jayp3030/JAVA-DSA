// According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
// The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

// Any live cell with fewer than two live neighbors dies as if caused by under-population.
// Any live cell with two or three live neighbors lives on to the next generation.
// Any live cell with more than three live neighbors dies, as if by over-population.
// Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

// The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.

// Example 1:
// Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
// Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]

// Example 2:
// Input: board = [[1,1],[1,0]]
// Output: [[1,1],[1,1]]

class Solution {
    public void gameOfLife(int[][] board) {
        int[][] neighbors = {
            {1,0},  // right
            {1,1},  // top right
            {0,1},  // top
            {-1,1}, // top left
            {-1,0}, // left
            {-1,-1},// bottom left
            {0,-1}, // bottom
            {1,-1}  // bottom right
        };

        for( int row = 0; row < board.length ; row++){
            for(int col = 0 ; col < board[0].length ; col++){
                int liveNeighbors = 0;

                for( int i = 0; i < neighbors.length ; i++){
                    int neighborRow = row + neighbors[i][0];
                    int neighborCol = col + neighbors[i][1];

                    if(isValid(neighborRow,neighborCol,board) && Math.abs(board[neighborRow][neighborCol]) == 1) liveNeighbors++;
                }

                if(board[row][col] == 1 && (liveNeighbors < 2 || liveNeighbors > 3))
                    board[row][col] = -1;   // become dead
                
                if(board[row][col] == 0 && liveNeighbors == 3)
                    board[row][col] = 2;    // become live
            }
        }

        for(int row = 0 ; row < board.length ; row++){
            for( int col = 0 ; col < board[0].length ; col++){
                if(board[row][col] == -1) board[row][col] = 0;
                if(board[row][col] == 2) board[row][col] = 1;
            }
        }

    }
    private boolean isValid( int x , int y , int[][] board){
        return (x >= 0 && x < board.length && y >= 0 && y < board[0].length);
    }
}