// Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.
// Implement the Solution class:
// Solution(ListNode head) Initializes the object with the head of the singly-linked list head.
// int getRandom() Chooses a node randomly from the list and returns its value. All the nodes of the list should be equally likely to be chosen.
 
// Example 1:

// Input
// ["Solution", "getRandom", "getRandom", "getRandom", "getRandom", "getRandom"]
// [[[1, 2, 3]], [], [], [], [], []]
// Output
// [null, 1, 3, 2, 2, 3]

// Explanation
// Solution solution = new Solution([1, 2, 3]);
// solution.getRandom(); // return 1
// solution.getRandom(); // return 3
// solution.getRandom(); // return 2
// solution.getRandom(); // return 2
// solution.getRandom(); // return 3
// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning

class Solution {
    ArrayList<Integer> list = new ArrayList<>();
    public Solution(ListNode head) {
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
    }
    
    public int getRandom() {
        // Math.random() return random value between 0 to 1
        // so if it generate 1 then randomIndex is list.size
        // if 0 then 0  
        // if any then between 0 to list size
        double randomIndex = Math.random() * list.size();  
        return list.get((int)randomIndex);
    }
}



// < -------------------------------- optimized solution ----------------------------------------> 

class Solution {
    Random r;
    int size;
    int[] arr;
    public Solution(ListNode head) {
        
        ListNode cur = head;
        while (cur != null) {                                       // to find size of ll
            size++;
            cur = cur.next;
        }

        arr = new int[size];
        int i = 0;
        cur = head;
        while (cur != null) {                                       // storing each node val into array
            arr[i++] = cur.val;
            cur = cur.next;
        }
    }
    
    public int getRandom() {
        r = new Random();
        int x = r.nextInt(size);                                    //for  getting random elements
        return arr[x];
    }
}