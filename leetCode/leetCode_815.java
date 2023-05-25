// You are given an array routes representing bus routes where routes[i] is a bus route that the ith bus repeats forever.
// For example, if routes[0] = [1, 5, 7], this means that the 0th bus travels in the sequence 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... forever.
// You will start at the bus stop source (You are not on any bus initially), and you want to go to the bus stop target. You can travel between bus stops by buses only.
// Return the least number of buses you must take to travel from source to target. Return -1 if it is not possible.

 

// Example 1:
// Input: routes = [[1,2,7],[3,6,7]], source = 1, target = 6
// Output: 2
// Explanation: The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.

// Example 2:
// Input: routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
// Output: -1

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) return 0;
        boolean foundS = false, foundT = false;
        for (int[] route : routes) {
            for (int i : route) {
                if(!foundS && i == source) foundS = true;
                if(!foundT && i == target) foundT = true;
            }
        }
        if (foundS == false || foundT == false) return -1;
        boolean[] visit = new boolean[routes.length];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < routes.length; i++){
            for(int x : routes[i]){
                List<Integer> list = map.getOrDefault(x, new ArrayList<>());
                list.add(i);
                map.put(x, list);
            }
        }
        int step = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        while(!q.isEmpty()){
            step++;
            int size = q.size();
            while(size-- > 0){
                int cur = q.poll();
                if(!map.containsKey(cur)) continue;
                for(int x : map.get(cur)){
                    if(visit[x]) continue;
                    visit[x] = true;
                    for(int y : routes[x]){
                        if(y == target) return step;
                        q.add(y);
                    }
                }
            }
        }
        return -1;
    }
}