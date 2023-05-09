// Given the head of a singly linked list, return true if it is a 
// palindrome or false otherwise.

// Example 1:
// Input: head = [1,2,2,1]
// Output: true

// Example 2:
// Input: head = [1,2]
// Output: false

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
    public boolean isPalindrome(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head.next;

        ListNode first = head;

        // geting middle of list (slow pointer) 
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode second = reverse(slow.next);
        slow.next = null;

        // comparing by iterating both list
        while(first!=null && second!=null){
            if(first.val!=second.val){
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return true;
    }
    
    // reversing remaining list 
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head!=null){
            ListNode temp = head.next;
            head.next=prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}