// Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

// Example 1:
// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2,2]

// Example 2:
// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [4,9]
// Explanation: [9,4] is also accepted.


class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int m = nums1.length;
        int n = nums2.length;

        ArrayList<Integer> l = new ArrayList<>();
        int i = 0 , j = 0;
        while(i < m && j < n){
            if(nums1[i] == nums2[j]){
                l.add(nums1[i]);
                i++;
                j++;
            }
            else if( nums1[i] < nums2[j]){
                i++;                          // to check nums1 element equivalent to nums2 because array is sort
            }
            else{
                j++;                 // to check nums2 elements equivalent to nums1                               
            }
        }

        int[] res = new int[l.size()];

        for( int p = 0 ; p < res.length ; p++) res[p] = l.get(p);

        return res;
        
    }
}