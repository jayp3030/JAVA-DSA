// Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

// Example 1:
// Input: head = [1,2,3,4,5], left = 2, right = 4
// Output: [1,4,3,2,5]

// Example 2:
// Input: head = [5], left = 1, right = 1
// Output: [5]

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if( head == null) return null;

        ListNode node = new ListNode(-1);
        ListNode prev = node;
        node.next = head;

        // to reach left position's previous node
        for(int i = 0 ; i < left - 1 ; i++) prev = prev.next;   

        ListNode curr = prev.next;
        ListNode next;

        for( int i = 0 ; i < right-left ; i++){
            // main swapping logic 
            // here prev remain as it is curr's position will upadated
            // and next will also updated with repect to curr 
            next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return node.next;   // beacause we added extra node -1 so node.next
    }
}