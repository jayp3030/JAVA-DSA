// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
// A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

// Example 1:
// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

// Example 2:
// Input: digits = ""
// Output: []

// Example 3:
// Input: digits = "2"
// Output: ["a","b","c"]

class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();
        if( digits.length() == 0) return res;

        HashMap<Character , String> map = new HashMap<>();

        map.put('2' ,"abc");
        map.put('3' ,"def");
        map.put('4' ,"ghi");
        map.put('5' ,"jkl");
        map.put('6' ,"mno");
        map.put('7' ,"pqrs");
        map.put('8' ,"tuv");
        map.put('9' ,"wxyz");

        backtrack(digits , 0 , map , new StringBuilder() , res);
        return res;
    }
    private void backtrack( String digits , int index , HashMap<Character,String> map ,StringBuilder sb , List<String> res){
        if( index == digits.length()){
            res.add(sb.toString());
            return;
        }

        String curr = map.get(digits.charAt(index));
        for( int i = 0 ; i < curr.length() ; i++){
            sb.append(curr.charAt(i));
            backtrack( digits, index+1 , map , sb , res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}