// Given two strings s and t of lengths m and n respectively, return the minimum window 
// substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

// The testcases will be generated such that the answer is unique.

// Example 1:
// Input: s = "ADOBECODEBANC", t = "ABC"
// Output: "BANC"
// Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

// Example 2:
// Input: s = "a", t = "a"
// Output: "a"
// Explanation: The entire string s is the minimum window.

// Example 3:
// Input: s = "a", t = "aa"
// Output: ""
// Explanation: Both 'a's from t must be included in the window.
// Since the largest window of s only has one 'a', return empty string.

class Solution {
    public String minWindow(String s, String t) {
        // base case
        if(s==null || t==null || s.length() == 0 || t.length() == 0 || s.length() < t.length())
            return new String();

        HashMap<Character , Integer> mapt = new HashMap<>();
        for( int i = 0 ; i < t.length() ; i++){
            char ch = t.charAt(i);
            mapt.put( ch , mapt.getOrDefault(ch , 0) + 1);
        }
        String ans = "";
        int i = -1;
        int j = -1;
        int mcnt = 0;   // match count
        int dmcnt = t.length(); // desired match count

        HashMap<Character , Integer> maps = new HashMap<>();

        while( true ){

            boolean f1 = false;
            boolean f2 = false;

            // acqiure
            while( j < s.length()-1 && mcnt < dmcnt){
                j++;
                char ch = s.charAt(j);
                maps.put(ch , maps.getOrDefault( ch , 0 )+1);
                if(maps.getOrDefault(ch ,0) <= mapt.getOrDefault(ch , 0)) mcnt++;  // we get kaam ka banda

                f1 = true; // to indicate that visited this loop
            }

            // collect answers and release 

            while( i < j && mcnt == dmcnt ){

                String pans = s.substring(i+1 , j+1);  // potential ans
                if( ans.length() == 0 || pans.length() < ans.length()){
                    ans = pans;
                }

                // release
                i++;
                char ch = s.charAt(i);
                if(maps.get(ch) == 1) maps.remove(ch);
                else maps.put( ch , maps.get(ch)-1);

                if( maps.getOrDefault(ch , 0) < mapt.getOrDefault(ch , 0)) 
                    mcnt--; // we lost kaam ka banda

                f2 = true;  // to indicate that visited this loop
            }
            if(f1 == false && f2 == false) break; // we did not entered in any of 2 loops
        } 
        return ans;
    }
}















