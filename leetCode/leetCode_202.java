// Write an algorithm to determine if a number n is happy.

// A happy number is a number defined by the following process:

// Starting with any positive integer, replace the number by the sum of the squares of its digits.
// Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
// Those numbers for which this process ends in 1 are happy.
// Return true if n is a happy number, and false if not.

// Example 1:
// Input: n = 19
// Output: true
// Explanation:
// 12 + 92 = 82
// 82 + 22 = 68
// 62 + 82 = 100
// 12 + 02 + 02 = 1

// Example 2:
// Input: n = 2
// Output: false

class Solution {
    public boolean isHappy(int n) {
        Map<Integer, Integer> h = new HashMap<>();
        for(int i=n;i<=Integer.MAX_VALUE;)
        {
            
            String s = String.valueOf(i);
            int sum = 0;

            for(int j=0;j<s.length();j++)
                sum = sum + (s.charAt(j) - '0') * (s.charAt(j) - '0');  // performing square sum
                
            // if hm has sum then the number will repeat anain and again so return false
            if(h.containsKey(sum))
                return false;

            if(sum == 1)
                return true;

            h.put(sum, h.getOrDefault(sum, 0)+1);

            i = sum;
        }
        return false;
    }
}