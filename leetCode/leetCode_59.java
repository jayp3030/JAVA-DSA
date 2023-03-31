// Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

// Example 1:
// Input: n = 3
// Output: [[1,2,3],[8,9,4],[7,6,5]]

// Example 2:
// Input: n = 1
// Output: [[1]]

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int rowStart = 0;
        int rowEnd = n-1;
        int colStart = 0;
        int colEnd = n-1;
        int counter=0;

        while(rowStart <= rowEnd && colStart <= colEnd && counter <= n*n){

            for(int i = colStart ; i <= colEnd ; i++){
                counter++;
                res[colStart][i] = counter;
            }
            rowStart++;

            for(int j = rowStart ; j <= rowEnd ; j++){
                counter++;
                res[j][colEnd] = counter;
            }
            colEnd--;

            if(rowStart <= rowEnd){
                for(int k = colEnd ; k >= colStart ; k--){
                    counter++;
                    res[rowEnd][k] = counter;
                }
            }
            rowEnd--;

            if(colStart <= colEnd){
                for(int l = rowEnd ; l >= rowStart ; l--){
                    counter++;
                    res[l][colStart] = counter;
                }
            }
            colStart++;
        }
        return res;
    }
}