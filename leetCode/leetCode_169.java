// Given an array nums of size n, return the majority element.
// The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

// Example 1:
// Input: nums = [3,2,3]
// Output: 3

// Example 2:
// Input: nums = [2,2,1,1,1,2,2]
// Output: 2

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;

        for( int num : nums){

            if(!map.containsKey(num)){
                map.put(num,1);
            }
            else{
                map.put(num , map.get(num)+1);
            }

            if(map.get(num) > nums.length/2){
                ans = num;
                break;
            }
               
        }
        return ans;

        // -------------------------optimized------------------------ 


        Arrays.sort(nums);
        return nums[nums.length/2];

    }
}