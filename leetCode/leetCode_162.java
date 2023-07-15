// A peak element is an element that is strictly greater than its neighbors.
// Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
// You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
// You must write an algorithm that runs in O(log n) time.

// Example 1:
// Input: nums = [1,2,3,1]
// Output: 2
// Explanation: 3 is a peak element and your function should return the index number 2.

// Example 2:
// Input: nums = [1,2,1,3,5,6,4]
// Output: 5
// Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.

class Solution {
    public int findPeakElement(int[] nums) {

        int n=nums.length;
        int start=0;
        int end=n-1;

    //if length of my array is 1 then return that 1st value itself
        if(n==1){
            return 0;
        }
    //checking 1st and 2nd element of array(if 1st element greater       than 2nd then return 1st element)
        if(nums[0]>nums[1]){
            return 0;
        }
    //same checking for last and last second element
        else if(nums[n-1]>nums[n-2]){
            return n-1;
        }
    // the above two checking is to be done because question demands one peak and by checking this condition we can get one peak.   

    // keeping 1st and last element aside because they're already checked and intiating our start and end from 2nd and last 2nd element resp.

            
        //doing binary search for the case when we have single peak
        start=1;
        end=n-2;
        while(start<=end){
            
            int mid=(start+end)/2;
            
            if(nums[mid]>nums[mid+1]  && nums[mid]>nums[mid-1]){
                return mid;
            }
            else if(nums[mid]>nums[mid-1]){
                start=mid+1;
            }
            else if(nums[mid]>nums[mid+1]){
                end=mid-1;
            }
        
            //these are the conditions we can check for multiple peaks
            else if(nums[mid]<nums[mid-1]){
                end=mid-1;
            }
            else if(nums[mid]<nums[mid+1]){
                start=mid+1;
            }            
        }
        return -1;
    }
}