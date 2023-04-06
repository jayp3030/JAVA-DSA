// The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.

// For example, "ACGAATTCCG" is a DNA sequence.
// When studying DNA, it is useful to identify repeated sequences within the DNA.

// Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.


// Example 1:

// Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
// Output: ["AAAAACCCCC","CCCCCAAAAA"]

// Example 2:

// Input: s = "AAAAAAAAAAAAA"
// Output: ["AAAAAAAAAA"]

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seenStrs = new HashSet<>();
        Set<String> repeatedStrs = new HashSet<>();

        for(int i = 0 ; i+9 < s.length() ; i++){
            String tenStr = s.substring(i,i+10);

            if(!seenStrs.add(tenStr))  // set only allow unique value so if we try to add duplicate it will not allow
                repeatedStrs.add(tenStr);
        }
        return new ArrayList(repeatedStrs);
    }
}