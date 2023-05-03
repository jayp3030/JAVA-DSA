// You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

// Return the length of the longest substring containing the same letter you can get after performing the above operations.

// Example 1:
// Input: s = "ABAB", k = 2
// Output: 4
// Explanation: Replace the two 'A's with two 'B's or vice versa.

// Example 2:
// Input: s = "AABABBA", k = 1
// Output: 4
// Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
// The substring "BBBB" has the longest repeating letters, which is 4.

class Solution {

    public int characterReplacement(String s, int k) {
        // get a character counter array
        int[] arr = new int[26];
        int ans = 0;
        int max = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            // increase every right character count in the array
            arr[s.charAt(right) - 'A']++;
            // find max between current max and the count of right character
            max = Math.max(max, arr[s.charAt(right) - 'A']);
            // see if ( right - left + 1 )[total sliding window length] 
            //           - max count of right character is greater than 'k'
            if (right - left + 1 - max > k) {
                // if not then reduce left count and slide right(add one to left window) 
                arr[s.charAt(left) - 'A']--;
                left++;
            }
            // ans = ans or windowSize (whichever is greater)
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}