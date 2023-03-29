// Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
// You must implement a solution with a linear runtime complexity and use only constant extra space.

// Example 1:
// Input: nums = [2,2,1]
// Output: 1

// Example 2:
// Input: nums = [4,1,2,1,2]
// Output: 4

// Example 3:
// Input: nums = [1]
// Output: 1

// ------------------------------------------------------------------------------------------------------------------------ 

// As we know XOR operation with 0 gives the same number
// i.e, a XOR 0 = a
// eg, for decimal no. 2=> 2 XOR 0 = 2
// in binary, 010 XOR 000 = 010

// Also we know that , XOR operation with same number gives 0
// i.e, a XOR a = 0
// eg, 2 XOR 2 = 0
// in binary, 010 XOR 010 = 000

class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for( int num : nums){
            ans ^= num;         // if there is no duplicate of any num then we get that num at the end
        }
        return ans;
    }
}