// You are given an array of strings words. Each element of words consists of two lowercase English letters.
// Create the longest possible palindrome by selecting some elements from words and concatenating them in any order. Each element can be selected at most once.
// Return the length of the longest palindrome that you can create. If it is impossible to create any palindrome, return 0.
// A palindrome is a string that reads the same forward and backward.

 

// Example 1:

// Input: words = ["lc","cl","gg"]
// Output: 6
// Explanation: One longest palindrome is "lc" + "gg" + "cl" = "lcggcl", of length 6.
// Note that "clgglc" is another longest palindrome that can be created.

// Example 2:

// Input: words = ["ab","ty","yt","lc","cl","ab"]
// Output: 8
// Explanation: One longest palindrome is "ty" + "lc" + "cl" + "yt" = "tylcclyt", of length 8.
// Note that "lcyttycl" is another longest palindrome that can be created.

// Example 3:

// Input: words = ["cc","ll","xx"]
// Output: 2
// Explanation: One longest palindrome is "cc", of length 2.
// Note that "ll" is another longest palindrome that can be created, and so is "xx".

class Solution {
    public int longestPalindrome(String[] words) {
      int result=0;
        Map<String,Integer> map=new HashMap<>();
        for(String s:words)
        {
            map.put(s,map.getOrDefault(s,0)+1);
        }
          int c=0;
        for(String s:map.keySet())
        {
            String s2=reverse(s);
            if(s.equals(s2)){  
                int val=map.get(s);
                     if(val%2!=0){val-=1;c=1;}
                
                result+=2*val;
                map.put(s,map.get(s)-val);
                    
            }
            else if(map.containsKey(s2)){
                int occ=Math.min(map.get(s),map.get(s2));
                result+=(4*occ);
              
                map.put(s,map.get(s)-occ);
                map.put(s2,map.get(s2)-occ);
            } 
        }
        
        return c==1?result+2:result;
            
    }
    public static String reverse(String str){
        StringBuilder sb=new StringBuilder(str);
        return sb.reverse().toString();
    }
}