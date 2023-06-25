// Given an array of positive integers nums and a positive integer target, return the minimal length of a 
// subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

// Example 1:
// Input: target = 7, nums = [2,3,1,2,4,3]
// Output: 2
// Explanation: The subarray [4,3] has the minimal length under the problem constraint.

// Example 2:
// Input: target = 4, nums = [1,4,4]
// Output: 1

// Example 3:
// Input: target = 11, nums = [1,1,1,1,1,1,1,1]
// Output: 0

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int sum = 0;        // current sum
        int res = Integer.MAX_VALUE; // shortest window of sum >= target

        while(right < n){
            sum += nums[right];     // add current element to the sum
            if(sum >= target){      // if sum >= target
                while( sum >= target){  // skip left elements until sum < target(to get smallest window size)
                    sum -= nums[left];
                    left++;
                }
                res = Math.min(res , right-left+2); // for min window size
            }
            right++;
        }

        return res == Integer.MAX_VALUE ? 0 : res;

    }
}