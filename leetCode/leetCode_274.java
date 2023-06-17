// Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.
// According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.

// Example 1:
// Input: citations = [3,0,6,1,5]
// Output: 3
// Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
// Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.

// Example 2:
// Input: citations = [1,3,1]
// Output: 1

class Solution {
    public int hIndex(int[] citations) {
        
        int[] bucket = new int[citations.length+1];

        for(int i = 0 ; i < citations.length ; i++){
            // here index is citation quality and and value is corresponding count of paper with that quality
            if(citations[i] > citations.length)
                bucket[bucket.length-1]++;
            else
                bucket[citations[i]]++;
        }

        int count = 0;
        for(int i = bucket.length-1 ; i >=0 ; i--){
            count += bucket[i];

            if(count >= i)  // count > citation quality
                return i;
        }

        return 0;
    }
}