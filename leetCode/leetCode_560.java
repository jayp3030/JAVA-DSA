// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

// A subarray is a contiguous non-empty sequence of elements within an array.

// Example 1:
// Input: nums = [1,1,1], k = 2
// Output: 2

// Example 2:
// Input: nums = [1,2,3], k = 3
// Output: 2

class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length+1];
        sum[0] = 0;
        int count = 0;

        for(int i = 1 ; i <= nums.length ; i++ ){
            sum[i] = sum[i-1]+nums[i-1];
        }

        for(int start = 0 ; start < sum.length ; start++){
            for(int end = start+1 ; end < sum.length ; end++){
                if(sum[end] - sum[start] == k)
                    count++;
            }
        }

        return count;
    }
}