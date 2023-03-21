// Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

// Example 1:
// Input: head = [1,2,6,3,4,5,6], val = 6
// Output: [1,2,3,4,5]

// Example 2:
// Input: head = [], val = 1
// Output: []

// Example 3:
// Input: head = [7,7,7,7], val = 7
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
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;

        ListNode curr = head , prev = fakeHead ;

        while(curr != null){
            if( curr.val == val){
                prev.next = curr.next;  // removed curr by joining prev and curr's next' 
            }
            else{
                prev = prev.next;       // increment prev
            }
            curr = curr.next;           // increment curr
        }
        return fakeHead.next;           // beacause fakeHead is -1 and 2nd node is head so ...
    }
}