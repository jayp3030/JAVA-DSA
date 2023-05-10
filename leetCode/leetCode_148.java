// Given the head of a linked list, return the list after sorting it in ascending order.

// Example 1:

// Input: head = [4,2,1,3]
// Output: [1,2,3,4]

// Example 2:

// Input: head = [-1,5,3,4,0]
// Output: [-1,0,3,4,5]

// Example 3:

// Input: head = []
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
    public ListNode sortList(ListNode head) {

        List<Integer> temp = new ArrayList<>();

        ListNode curr = head;

        while(curr != null){
            temp.add(curr.val);
            curr = curr.next;
        }
        Collections.sort(temp);

        curr = head;

        for(int nodeVal : temp){
            curr.val = nodeVal;
            curr = curr.next;
        }

        return head;
    }
}