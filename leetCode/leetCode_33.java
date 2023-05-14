// There is an integer array nums sorted in ascending order (with distinct values).
// Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
// Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
// You must write an algorithm with O(log n) runtime complexity.

// Example 1:
// Input: nums = [4,5,6,7,0,1,2], target = 0
// Output: 4

// Example 2:
// Input: nums = [4,5,6,7,0,1,2], target = 3
// Output: -1

// Example 3:
// Input: nums = [1], target = 0
// Output: -1


// The code initializes the left and right pointers, representing the indices of the leftmost and rightmost elements in the search range.It enters a while loop where the search range is not empty (left <= right).

// In each iteration, the code calculates the middle index mid as the average of the left and right indices.

// If the target is equal to the element at the mid index, the function returns mid as the index of the target element.

// If the element at the left index is less than or equal to the element at the mid index, it means the left half of the array is sorted in ascending order.

// If the target is within the range of the left half (between left and mid), the right pointer is updated to mid - 1 to continue the search in the left half.
// Otherwise, the left pointer is updated to mid + 1 to search in the right half.

// If the element at the left index is greater than the element at the mid index, it means the right half of the array is sorted in ascending order.
// If the target is within the range of the right half (between mid and right), the left pointer is updated to mid + 1 to continue the search in the right half.
// Otherwise, the right pointer is updated to mid - 1 to search in the left half.

// If the target is not found in the array, the while loop terminates, and the function returns -1 to indicate that the target is not present in the array.

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        
        while(left <= right){
            int mid = (left+right)/2;

            if(nums[mid] == target)
                return mid;
            
            if(nums[left] <= nums[mid]){
                if(nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                }
                else{
                    left = mid+1;
                }
            }
            else{
                 if(nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }

            }
        
            
        }

        return -1;
    }
}