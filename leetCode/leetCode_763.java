// You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.

// Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.

// Return a list of integers representing the size of these parts.

// Example 1:
// Input: s = "ababcbacadefegdehijhklij"
// Output: [9,7,8]
// Explanation:
// The partition is "ababcbaca", "defegde", "hijhklij".
// This is a partition so that each letter appears in at most one part.
// A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.

// Example 2:
// Input: s = "eccbbbbdec"
// Output: [10]

class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character , Integer> map = new HashMap<>();

        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            map.put(c,i);           // in map we have last occurences of all the characters
        }

        int maxRange = 0 ;
        int prevRange = -1;
        List<Integer> res = new ArrayList<>();
        
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);

            maxRange = Math.max(maxRange,map.get(c));         // finding range of char

            // partition
            if(maxRange == i){
                res.add(maxRange-prevRange);
                prevRange = maxRange;
            } 
        }
        return res;
    }
}
