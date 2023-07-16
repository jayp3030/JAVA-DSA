// Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
// If target is not found in the array, return [-1, -1].
// You must write an algorithm with O(log n) runtime complexity.

// Example 1:
// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]

// Example 2:
// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]

// Example 3:
// Input: nums = [], target = 0
// Output: [-1,-1]

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int[] res = {-1 , -1};
        if( nums == null || nums.length == 0) return res;

        int start = 0;
        int end = nums.length-1;

        // first occurence
        while(start <= end){
            int mid = (start+end)/2;

            if(nums[mid] == target){
                res[0] = mid;
                end = mid-1;  //because mid may not actual first occerence
            }
            else if( target < nums[mid]) end = mid-1;
            else if( target > nums[mid]) start = mid+1;
        }

        start = 0;
        end = nums.length-1;
        
        // last occurence
        while(start <= end){
            int mid = (start+end)/2;

            if(nums[mid] == target){
                res[1] = mid;
                start = mid+1;  //mid may not actual last occerence 
            }
            else if( target < nums[mid]) end = mid-1;
            else if( target > nums[mid]) start = mid+1;
        }

        return res;
    }
}