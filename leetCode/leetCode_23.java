// You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
// Merge all the linked-lists into one sorted linked-list and return it.

// Example 1:
// Input: lists = [[1,4,5],[1,3,4],[2,6]]
// Output: [1,1,2,3,4,4,5,6]
// Explanation: The linked-lists are:
// [
//   1->4->5,
//   1->3->4,
//   2->6
// ]
// merging them into one sorted list:
// 1->1->2->3->4->4->5->6

// Example 2:
// Input: lists = []
// Output: []

// Example 3:
// Input: lists = [[]]
// Output: []

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


// just use priority queue
// make a list node of ans
// then keep curr to add the elements to ans
// then pop from the priority queue and then move curr to next check if the next element of curr is not null if not null then add to queue

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if( lists == null || lists.length == 0) return null;

        // priority = minimum
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val-b.val);

        for( ListNode node : lists){
            if( node != null) pq.add(node);
        }

        ListNode ans = new ListNode(-1);
        ListNode curr = ans;

        while(!pq.isEmpty()){
            curr.next = pq.remove();    // we get min val always
            curr = curr.next;

            if( curr.next != null) pq.add(curr.next);
        }

        return ans.next;
    }
}