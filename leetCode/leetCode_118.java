// Given an integer numRows, return the first numRows of Pascal's triangle.

// In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


// Example 1:
// Input: numRows = 5
// Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

// Example 2:
// Input: numRows = 1
// Output: [[1]]

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        if(numRows == 0) return result;
        // first element of result is always [1] for pascal triangle so that ...
        result.add(new ArrayList<>());              
        result.get(0).add(1);

        for(int i = 1 ; i < numRows ; i++){
            List<Integer> temp = new ArrayList<>();

            temp.add(1);                            // for any row first element is [1]
            for(int j = 1; j < i ; j++){
                temp.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
            }
            temp.add(1);                            // for any row last element is [1]

            result.add(temp);
        }
        return result;
    }
}