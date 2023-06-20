// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

// Example 1:
// Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6
// Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

// Example 2:
// Input: height = [4,2,0,3,2,5]
// Output: 9

class Solution {
    public int trap(int[] height) {
        int n = height.length;

        if(n <= 2) return 0;

        int maxLeft = height[0];
        int maxRight = height[n-1];

        int leftPtr = 1;    //second pillar
        int rightPtr = n-2; // second last pillar
        int trpWtr = 0;

        while(leftPtr <= rightPtr){
            // we will trap water from lower height from max boundries
            if(maxLeft < maxRight){
            // if current pillar is higher than maxLeft then we can't trap water at that place and maxLeft is updated
                if(height[leftPtr] > maxLeft){  
                    maxLeft = height[leftPtr];
                }
                else{
                    trpWtr += maxLeft - height[leftPtr];
                    leftPtr++;
                }
            }
            else{
                // same as left
                if(height[rightPtr] > maxRight){
                    maxRight = height[rightPtr];
                }
                else{
                    trpWtr += maxRight - height[rightPtr];
                    rightPtr--;
                }
            }
        }
        return trpWtr;
    }
}