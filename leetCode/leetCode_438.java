// Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

// Example 1:
// Input: s = "cbaebabacd", p = "abc"
// Output: [0,6]
// Explanation:
// The substring with start index = 0 is "cba", which is an anagram of "abc".
// The substring with start index = 6 is "bac", which is an anagram of "abc".

// Example 2:
// Input: s = "abab", p = "ab"
// Output: [0,1,2]
// Explanation:
// The substring with start index = 0 is "ab", which is an anagram of "ab".
// The substring with start index = 1 is "ba", which is an anagram of "ab".
// The substring with start index = 2 is "ab", which is an anagram of "ab".

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        int S = s.length();
        int P = p.length();

        if( P > S) return res;

        int[] pFreq = frequency(p);                         // pattern's char frequency 
        int[] currwndFreq = frequency(s.substring(0,P));  

        if(compare(pFreq , currwndFreq ))
            res.add(0);
        
        for(int i = P ; i < S ; i++){
            currwndFreq[s.charAt(i - P) - 'a']--;       // realeasing 
            currwndFreq[s.charAt(i) - 'a']++;           // acquiring

            if(compare(pFreq , currwndFreq))
                res.add(i-P+1);

        }

        return res;
        

    }
    private int[] frequency(String str){
        int[] freq = new int[26];
        for(int i = 0 ; i < str.length() ; i++){
            freq[str.charAt(i) - 'a']++;
        }
        return freq;
    }

    private boolean compare(int[] x , int[] y){         // check for anagrams
        for(int i = 0 ; i < 26 ; i++){
            if(x[i] != y[i])
                return false;
        }
        return true;
    }
}