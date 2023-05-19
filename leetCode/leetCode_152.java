// Given an integer array nums, find a subarray that has the largest product, and return the product.
// The test cases are generated so that the answer will fit in a 32-bit integer.

// Example 1:
// Input: nums = [2,3,-2,4]
// Output: 6
// Explanation: [2,3] has the largest product 6.

// Example 2:
// Input: nums = [-2,0,-1]
// Output: 0
// Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

class Solution {
    public int maxProduct(int[] nums) {
        int curr = 1;
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        for( int i = 0 ; i < len ; i++){
            curr *= nums[i];
            if(curr > max){
                max = curr;
            }
            if(curr == 0){
                curr = 1;
            }
        }
        curr = 1;
        for( int j = len - 1 ; j >= 0 ; j--){
            curr *= nums[j];
            if(curr > max){
                max = curr;
            }
            if(curr == 0){
                curr = 1;
            }
        }
        return max;
    }
}