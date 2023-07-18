// Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
// The overall run time complexity should be O(log (m+n)).

// Example 1:
// Input: nums1 = [1,3], nums2 = [2]
// Output: 2.00000
// Explanation: merged array = [1,2,3] and median is 2.

// Example 2:
// Input: nums1 = [1,2], nums2 = [3,4]
// Output: 2.50000
// Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      int l1=nums1.length;  //length of first array
      int l2=nums2.length;   //length of second array
      int n=l1+l2;   
      int temp[]=new int[n];

      System.arraycopy(nums1,0,temp,0,l1); //copying first array in new array
      System.arraycopy(nums2,0,temp,l1,l2); //copying second array in new array

      Arrays.sort(temp); //using inbuilt sorting method

      if(n%2==0){  //for even length array
          int index1=(n/2)-1;
          int index2=(n/2);

          return (double)((temp[index1])+(temp[index2]))/2;
      }

      int index=n/2; 
      return (double)temp[index];
    }
}