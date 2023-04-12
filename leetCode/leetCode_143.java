// You are given the head of a singly linked-list. The list can be represented as:

// L0 → L1 → … → Ln - 1 → Ln
// Reorder the list to be on the following form:

// L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
// You may not modify the values in the list's nodes. Only nodes themselves may be changed.

// Example 1:

// Input: head = [1,2,3,4]
// Output: [1,4,2,3]

// Example 2:

// Input: head = [1,2,3,4,5]
// Output: [1,5,2,4,3]

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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        Stack<ListNode> s1 = new Stack<>();

        // push all node in stack
        ListNode curr = head;
        while(curr != null){
            s1.push(curr);
            curr = curr.next;
        }

        int count = (s1.size() - 1)/2;   // to find how many node from right side to be reordered for 2nd example i is 2...
        ListNode node = head;

        while(count > 0){
            // swap process
            ListNode topNode = s1.pop();
            ListNode temp = node.next;
            node.next = topNode;
            topNode.next = temp;
            node = temp;

            count--;
        }
        s1.pop().next = null;       // to avoid cycle
        
    }
}