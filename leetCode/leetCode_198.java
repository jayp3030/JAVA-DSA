// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
// Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

// Example 1:
// Input: nums = [1,2,3,1]
// Output: 4
// Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
// Total amount you can rob = 1 + 3 = 4.

// Example 2:
// Input: nums = [2,7,9,3,1]
// Output: 12
// Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
// Total amount you can rob = 2 + 9 + 1 = 12.

class Solution {
    public int rob(int[] nums) {
        // Initialize variables to keep track of the maximum amount robbed at the current and previous houses.
        int curMax = 0; // Current maximum amount robbed
        int preMax = 0; // Maximum amount robbed at the previous house

        // Iterate over each house in the array
        for(int num: nums) {
            // Store the current value of curMax in a temporary variable
            int temp = curMax;
            // Calculate the maximum amount that can be robbed at the current house, either by skipping the current house and taking the maximum amount robbed at the previous house, or by robbing the current house and adding it to the maximum amount robbed at the house before the previous house
            curMax = Math.max(num + preMax, curMax);
            // Update the previous maximum amount robbed to the value of the previous current maximum amount robbed
            preMax = temp;
        }

        // Return the final maximum amount robbed
        return curMax;
    }
}