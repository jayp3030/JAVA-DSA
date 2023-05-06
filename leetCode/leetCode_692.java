// Given an array of strings words and an integer k, return the k most frequent strings.

// Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.

// Example 1:
// Input: words = ["i","love","leetcode","i","love","coding"], k = 2
// Output: ["i","love"]
// Explanation: "i" and "love" are the two most frequent words.
// Note that "i" comes before "love" due to a lower alphabetical order.

// Example 2:
// Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
// Output: ["the","is","sunny","day"]
// Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        // keep track of freq of strings

        Map<String , Integer> map = new HashMap<>();

        for(String word : words){
            map.put(word , map.getOrDefault(word , 0)+1);
        } 

        // using priority queue to get most frequnt string

        PriorityQueue<String> pq = new PriorityQueue<>( new Comparator<String>(){
            @Override

            public int compare(String w1 , String w2){
                int freq1 = map.get(w1);
                int freq2 = map.get(w2);

                if(freq1 == freq2) return w2.compareTo(w1);

                return freq1 - freq2;
            }

        });

        for( Map.Entry<String ,Integer> entry : map.entrySet()){
            pq.add(entry.getKey());
            if(pq.size() > k) pq.remove();
        }

        List<String> res = new ArrayList<>();

        while(!pq.isEmpty()){
            res.add(pq.remove());
        }

        Collections.reverse(res);

        return res;
    }
}