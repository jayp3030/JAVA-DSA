// Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

// k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

// You may not alter the values in the list's nodes, only nodes themselves may be changed.

// Example 1:

// Input: head = [1,2,3,4,5], k = 2
// Output: [2,1,4,3,5]

// Example 2:

// Input: head = [1,2,3,4,5], k = 3
// Output: [3,2,1,4,5]


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
    public ListNode reverseKGroup(ListNode head, int k) {

        if(head == null || head.next == null || k < 2) return head;
        // size of LL
        int count = 0;
        ListNode curr = head;
        while(curr != null){
            count++;
            curr = curr.next;
        }

        ListNode fakeH = new ListNode(0);
        fakeH.next = head;

        ListNode start = fakeH;
        ListNode end = fakeH.next;

        for(int i = count ; i >=k ; i -=k){             // how many groups to be reversed
            for(int j = 1 ; j < k ; j++){               // reverse the group
                ListNode nextNode = end.next;
                end.next = nextNode.next;
                nextNode.next = start.next;
                start.next = nextNode;
            }
            start = end;                                // updating start 
            end = start.next;                           // updating end
        } 
        return fakeH.next;  
    }
    
}