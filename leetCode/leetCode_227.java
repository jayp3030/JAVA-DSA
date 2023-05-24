// Given a string s which represents an expression, evaluate this expression and return its value. 
// The integer division should truncate toward zero.
// You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].

// Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

 

// Example 1:
// Input: s = "3+2*2"
// Output: 7

// Example 2:
// Input: s = " 3/2 "
// Output: 1

// Example 3:
// Input: s = " 3+5 / 2 "
// Output: 5


class Solution {
    public int calculate(String s) {
        int res=0,curr=0,i=0,n=s.length();
        char op='+';
        Stack<Integer> stack = new Stack<Integer>();
        for(char ch: s.toCharArray()){
            if(Character.isDigit(ch))
                curr=curr*10+ch-'0';

            if(i==n-1 || (!Character.isDigit(ch) && ch!=' ')){
                if(op=='+')
                    stack.push(curr);
                else if(op=='-')
                    stack.push(-curr);
                else if(op=='*')
                    stack.push(curr*stack.pop());
                else if(op=='/')
                    stack.push(stack.pop()/curr);

                op=ch;
                curr=0;
            }
            
            i++;
        }
        while(!stack.isEmpty()) res+=stack.pop();
        
        return res;
    }
}