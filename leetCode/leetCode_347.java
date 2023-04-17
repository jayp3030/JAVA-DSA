// Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

// Example 1:
// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]

// Example 2:
// Input: nums = [1], k = 1
// Output: [1]

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){ map.put(num, map.getOrDefault(num, 0) + 1); }
        
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        // (a, b) -> map.get(b) - map.get(a) to make more priority to bigger number
        
        for(int key : map.keySet()){ 
            heap.add(key);
        }

        int[] ans = new int[k];
        for(int i = 0; i < k; i++){
            ans[i] = heap.remove();
        }
        
        return ans;
    }
}