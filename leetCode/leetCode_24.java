// Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

// Example 1:
// Input: head = [1,2,3,4]
// Output: [2,1,4,3]

// Example 2:
// Input: head = []
// Output: []

// Example 3:
// Input: head = [1]
// Output: [1]

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
    public ListNode swapPairs(ListNode head) {
        
        if( head == null || head.next == null)      // empty or only one node
            return head;

        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode newH = prev;                       //Storing a reference for return head

        while(prev.next != null && prev.next.next != null){
            ListNode n1 = prev.next;                        // ...[prev]-->[node1]-->[node2]-->[next]...
            ListNode n2 = n1.next;
            ListNode next = n2.next;

            // swap

            prev.next = n2;                         // ...[prev]-->[node2]<--[node1]   [next]...
            n2.next = n1;                           // ...[prev]-->[node2]<-->[node1]  [next]...
            n1.next = next;                         // ...[prev]-->[node2]-->[node1]-->[next]...

            // update 

            prev = n1;                              // ...[...]-->[node2]-->[node1/prev]-->[next]..
        } 
        return newH.next;
    }
}
