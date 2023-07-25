// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

// Example 1:
// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]

// Example 2:
// Input: n = 1
// Output: ["()"]

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(0,0,n,"",res);
        return res;
    }
    private void backtrack(int open , int close , int max , String str , List<String> res){
        if(str.length() == max*2){
            System.out.println(str);
            res.add(str);
            return;
        }

        if( open < max) backtrack( open+1 , close , max , str+"(" , res );
        if( close < open) backtrack( open , close+1 , max , str+")" , res );
    }
}