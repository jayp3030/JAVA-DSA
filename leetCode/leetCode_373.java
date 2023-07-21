// You are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k.
// Define a pair (u, v) which consists of one element from the first array and one element from the second array.
// Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.

// Example 1:
// Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
// Output: [[1,2],[1,4],[1,6]]
// Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

// Example 2:
// Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
// Output: [[1,1],[1,1]]
// Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]

// Example 3:
// Input: nums1 = [1,2], nums2 = [3], k = 3
// Output: [[1,3],[2,3]]
// Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        // comparing on the basis of sum of the value of 0,1 element 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]+a[1]-(b[0]+b[1]));
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0; i<nums1.length && i<k; i++) 
            pq.add(new int[]{nums1[i], nums2[0], 0});

        while(k-- > 0 && !pq.isEmpty()){
            int[] curr = pq.remove();
            int index = curr[2];

            List<Integer> temp =new ArrayList<>();
            temp.add(curr[0]);  // nums1 element
            temp.add(curr[1]);  // nums2 element
            
            res.add(temp);

            if(curr[2] == nums2.length-1) // curr[2] = index of nums2 element
                continue;

            pq.add(new int[]{curr[0],nums2[index+1], index+1});
        }
        return res;
    }
}