// Given a string s of '(' , ')' and lowercase English characters.

// Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

// Formally, a parentheses string is valid if and only if:

// It is the empty string, contains only lowercase characters, or
// It can be written as AB (A concatenated with B), where A and B are valid strings, or
// It can be written as (A), where A is a valid string.
 

// Example 1:

// Input: s = "lee(t(c)o)de)"
// Output: "lee(t(c)o)de"
// Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.

// Example 2:

// Input: s = "a)b(c)d"
// Output: "ab(c)d"

// Example 3:

// Input: s = "))(("
// Output: ""
// Explanation: An empty string is also valid.

class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0 ; i < s.length() ; i++){
            
            char c = s.charAt(i);

            if(Character.isAlphabetic(c)){
                continue;
            }
            else if(c == '('){
                st.push(i);
            }
            else{
                if( !st.isEmpty() && s.charAt(st.peek()) == '(')
                    st.pop();
                else
                    st.push(i);
            }
        }
        // at the end st contains invalid parentheses index

        StringBuilder result = new StringBuilder();
        HashSet<Integer> set = new HashSet<>(st);
        for(int i=0;i<s.length();i++)   
            if(!set.contains(i))              // if set has index of invalid parentheses then we are not going to append it
                result.append(s.charAt(i));
        
        return result.toString();
        
    }
}