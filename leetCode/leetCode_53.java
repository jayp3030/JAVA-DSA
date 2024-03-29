// Given an integer array nums, find the subarray with the largest sum, and return its sum.

// Example 1:
// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: The subarray [4,-1,2,1] has the largest sum 6.

// Example 2:
// Input: nums = [1]
// Output: 1
// Explanation: The subarray [1] has the largest sum 1.

// Example 3:
// Input: nums = [5,4,-1,7,8]
// Output: 23
// Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.


// -------------------------------------------------- KADANE'S Alog --------------------------------------- 

class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;

        int currentSum =nums[0];
        int overallSum = nums[0];

        for( int i = 1 ; i < n ; i++){
            // if current element find that previous sum is positive then current will join it for its benefit
            // else current element start with its own value
            if(currentSum >= 0){
                currentSum += nums[i];
            }
            else{
                currentSum = nums[i];
            }

            if( currentSum > overallSum){
                overallSum = currentSum;
            }
        }
        return overallSum;
    }
}