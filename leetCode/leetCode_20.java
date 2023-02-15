// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Every close bracket has a corresponding open bracket of the same type.
 

// Example 1:

// Input: s = "()"
// Output: true
// Example 2:

// Input: s = "()[]{}"
// Output: true
// Example 3:

// Input: s = "(]"
// Output: false

class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> s1 = new Stack<>();

        for ( Character c : s.toCharArray()){

            switch(c){

                case  '(':
                case  '[':
                case  '{':

                    s1.push(c);
                    break;
                case ')':
                    if(s1.isEmpty() || s1.pop()!='('){
                        return false;
                    }
                    break;
                case ']':
                    if(s1.isEmpty() || s1.pop()!='['){
                        return false;
                    }
                    break;
                 case '}':
                    if(s1.isEmpty() || s1.pop()!='{'){
                        return false;
                    }
                    break;
            }
        }

        // if all brackets are valid then stack become empty else there are unused brackes in stack
        return s1.isEmpty();

    }
}
