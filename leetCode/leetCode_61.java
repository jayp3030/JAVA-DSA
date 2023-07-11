// Given the head of a linked list, rotate the list to the right by k places.

// Example 1:
// Input: head = [1,2,3,4,5], k = 2
// Output: [4,5,1,2,3]

// Example 2:
// Input: head = [0,1,2], k = 4
// Output: [2,0,1]

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
    public ListNode rotateRight(ListNode head, int k) {
        if( head == null || k == 0) return head;

        ListNode curr = new ListNode();
        curr = head;
        int cnt = 1;

        // counting total nodes
        while(curr.next != null){
            curr = curr.next;
            cnt++;
        }

        curr.next = head;
        //Taking the remainder ensures that k is within the range of the linked list length.
        k = k % cnt;  
        //obtain the number of nodes that should be rotated from the beginning of the linked list to the end
        k = cnt - k;

        while(k-- > 0){
            curr = curr.next;
        }
        head = curr.next;
        curr.next = null;

        return head;
        
    }
}