// Given an array of strings strs, group the anagrams together. You can return the answer in any order.

// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

// Example 1:
// Input: strs = ["eat","tea","tan","ate","nat","bat"]
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

// Example 2:
// Input: strs = [""]
// Output: [[""]]

// Example 3:
// Input: strs = ["a"]
// Output: [["a"]]

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String , List<String>> map = new HashMap<>();

        for(int i = 0 ; i < strs.length ; i++){
            
            String s = strs[i];
            char[] charArr = s.toCharArray();
            // Two strings are anagrams if and only if their sorted strings are equal.
            Arrays.sort(charArr);
            String str = new String(charArr);

            if(map.containsKey(str)){
                map.get(str).add(s);
            }
            else{
                map.put(str,new ArrayList());
                map.get(str).add(s);
            }
        }
        return new ArrayList(map.values());
        
    }
}