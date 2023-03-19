// You are given an m x n integer matrix matrix with the following two properties:

// Each row is sorted in non-decreasing order.
// The first integer of each row is greater than the last integer of the previous row.
// Given an integer target, return true if target is in matrix or false otherwise.

// You must write a solution in O(log(m * n)) time complexity.

 

// Example 1:

// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
// Output: true

// Example 2:

// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
// Output: false

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;

        while(i < matrix.length && j >= 0 ){
            if(matrix[i][j] == target){
                return true;
            }
            else if(target < matrix[i][j]){
                // beacause target < currentElement then we have to find it in same row but in different column
                j--;
            }
            else{
                // because target > currentElement so we have to find it in different row
                i++;                    
            }
        }
        return false;
    }
}