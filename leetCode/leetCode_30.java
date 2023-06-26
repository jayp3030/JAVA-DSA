// You are given a string s and an array of strings words. All the strings of words are of the same length.
// A concatenated substring in s is a substring that contains all the strings of any permutation of words concatenated.
// For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated substring because it is not the concatenation of any permutation of words.
// Return the starting indices of all the concatenated substrings in s. You can return the answer in any order.

// Example 1:
// Input: s = "barfoothefoobarman", words = ["foo","bar"]
// Output: [0,9]
// Explanation: Since words.length == 2 and words[i].length == 3, the concatenated substring has to be of length 6.
// The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
// The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.
// The output order does not matter. Returning [9,0] is fine too.

// Example 2:
// Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
// Output: []
// Explanation: Since words.length == 4 and words[i].length == 4, the concatenated substring has to be of length 16.
// There is no substring of length 16 is s that is equal to the concatenation of any permutation of words.
// We return an empty array.

// Example 3:
// Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
// Output: [6,9,12]
// Explanation: Since words.length == 3 and words[i].length == 3, the concatenated substring has to be of length 9.
// The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"] which is a permutation of words.
// The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"] which is a permutation of words.
// The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"] which is a permutation of words.

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        // base case
        if(s == null || s.length() == 0 || words == null || words.length == 0)
            return new ArrayList();

        // track freq of word in words
        Map<String , Integer> freqMap = new HashMap<>();    
        for( String word : words){
            freqMap.put(word , freqMap.getOrDefault(word , 0) + 1);
        }

        int eachWordLength = words[0].length();
        int totalWords = words.length;
        List<Integer> res = new ArrayList<>();

        // iterating String s one by one word
        for( int i = 0 ; i <= s.length() - (eachWordLength * totalWords) ; i++){

            Map<String , Integer> seenWrd = new HashMap<>();

            for( int j = 0 ; j < totalWords ; j++){

                int wordIdx = i + j * eachWordLength;
                String word = s.substring(wordIdx , wordIdx + eachWordLength);

                if(! freqMap.containsKey(word)) break;

                seenWrd.put(word , seenWrd.getOrDefault(word , 0) + 1);

                if(seenWrd.get(word) > freqMap.getOrDefault(word , 0)) break;

                if(j + 1 == totalWords) res.add(i);
            }
        }
        return res;
    }
}