// Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

// Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:

// Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
// Return k.

// Example 1:

// Input: nums = [3,2,2,3], val = 3
// Output: 2, nums = [2,2,_,_]
// Explanation: Your function should return k = 2, with the first two elements of nums being 2.
// It does not matter what you leave beyond the returned k (hence they are underscores).
// Example 2:

// Input: nums = [0,1,2,2,3,0,4,2], val = 2
// Output: 5, nums = [0,1,4,0,3,_,_,_]
// Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
// Note that the five elements can be returned in any order.
// It does not matter what you leave beyond the returned k (hence they are underscores).

// ----------------------------------------------------------------------------------------------------------------------------------------------

// The code initializes two pointers, i and j, both initially set to 0.

// It enters a while loop where j is less than the length of the array.

// In each iteration, the code checks if the element at index j is equal to the target value:
    // If it is equal, it means the element should be removed, so the pointers are not    updated, and j is incremented.
    // If it is not equal, it means the element should be kept in the modified array. The element at index j is copied to the position i in the array, and both i and j are incremented.

// The loop continues until all elements in the array have been scanned.

// Finally, the code returns the value of i, which represents the length of the modified array.
class Solution {
    public int removeElement(int[] nums, int val) {
        int i=0;
        int j=0;
        while(j < nums.length)
        {
            if(nums[j] != val)
            {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        return i;
    }
}