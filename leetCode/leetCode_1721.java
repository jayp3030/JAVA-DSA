// You are given the head of a linked list, and an integer k.
// Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).

//  Example 1:
// Input: head = [1,2,3,4,5], k = 2
// Output: [1,4,3,2,5]

// Example 2:
// Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
// Output: [7,9,6,6,8,7,3,0,9,5]

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
    public ListNode swapNodes(ListNode head, int k) {
        
        ListNode leftnode = head;
        ListNode rightnode = head;

        for(int i=1 ; i < k ; i++ ){        // kth node from beginning
            leftnode = leftnode.next;
        }        

        ListNode curr = leftnode;

        while(curr.next != null){       // kth node from end
            curr = curr.next;
            rightnode = rightnode.next;
        }

        // swaping
        int temp = leftnode.val;
        leftnode.val = rightnode.val;
        rightnode.val = temp;

        return head;
    }
}