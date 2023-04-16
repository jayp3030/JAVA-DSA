// In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.

// If the town judge exists, then:

// The town judge trusts nobody.
// Everybody (except for the town judge) trusts the town judge.
// There is exactly one person that satisfies properties 1 and 2.
// You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi. If a trust relationship does not exist in trust array, then such a trust relationship does not exist.

// Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.

// Example 1:
// Input: n = 2, trust = [[1,2]]
// Output: 2

// Example 2:
// Input: n = 3, trust = [[1,3],[2,3]]
// Output: 3

// Example 3:
// Input: n = 3, trust = [[1,3],[2,3],[3,1]]
// Output: -1

class Solution {
    public int findJudge(int n, int[][] trust) {
        if(trust.length == 0 && n == 1 ) return 1;

        HashSet<Integer> hs = new HashSet<>();          // here we store simple person
        HashMap<Integer,Integer> hm = new HashMap<>();  // here we store trusted person as key and trusted by as value

        for(int i = 0 ; i < trust.length ; i++){

            hs.add(trust[i][0]);                    // here we store simple person(if a person trust on other then person is simple person)

            int key = trust[i][1];

            if(hm.containsKey(key)){               // here we store trusted person as key and trusted by as value
                hm.put(key , hm.get(key)+1);
            }
            else{
                hm.put(key , 1);
            }
        }

        for(Integer key : hm.keySet()){
            if( hs.contains(key) == false && hm.get(key) == n-1){
                return key;
            }
        }

        return -1;
    }
}