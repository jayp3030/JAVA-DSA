// Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.
// A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].
// A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.

 

// Example 1:
// Input: nums = [1,-2,3,-2]
// Output: 3
// Explanation: Subarray [3] has maximum sum 3.

// Example 2:
// Input: nums = [5,-3,5]
// Output: 10
// Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.

// Example 3:
// Input: nums = [-3,-2,-3]
// Output: -2
// Explanation: Subarray [-2] has maximum sum -2.

class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int array_SUM = 0;

        int min_SUM = Integer.MAX_VALUE;
        int tempmin_SUM = 0;

        int max_SUM = Integer.MIN_VALUE;
        int tempmax_SUM = 0;

        for(int i = 0; i < nums.length ; i++){
            array_SUM += nums[i];

            tempmax_SUM += nums[i];
            max_SUM = tempmax_SUM > max_SUM ? tempmax_SUM : max_SUM;
            tempmax_SUM = tempmax_SUM > 0 ? tempmax_SUM : 0;

            tempmin_SUM += nums[i];
            min_SUM = tempmin_SUM < min_SUM ? tempmin_SUM : min_SUM;
            tempmin_SUM = tempmin_SUM < 0 ? tempmin_SUM : 0;
        }

        // when all the values are negative array_SUM and min_SUM become equal 
        // in that we return simply max_SUM (simple kadane's algo)
        if( array_SUM == min_SUM) return max_SUM;

        // otherwise we return max of..
        // max_SUM (simple kadane's - straight array) and array_SUM - min_SUM
        return Math.max(max_SUM , (array_SUM - min_SUM));

    }
}

