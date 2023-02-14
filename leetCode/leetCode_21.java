// You are given the heads of two sorted linked lists list1 and list2.

// Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

// Return the head of the merged linked list.

// Input: list1 = [1,2,4], list2 = [1,3,4]
// Output: [1,1,2,3,4,4]
// Example 2:

// Input: list1 = [], list2 = []
// Output: []
// Example 3:

// Input: list1 = [], list2 = [0]
// Output: [0]

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        // if first LL is blank then 2nd is already sorted
        if(list1 == null){
            return list2;
        }

        // if second LL is blank then 1st is already sorted
        if(list2 == null){
            return list1;
        }

        ListNode t1 = list1;
        ListNode t2 = list2;

        ListNode ansHead = null;
        ListNode ansTail = null;

        // first node of merged sorted list
        if(t1.val <= t2.val){
            ansHead = t1;
            ansTail = t1;
            t1 = t1.next;
        }
        else{
            ansHead = t2;
            ansTail = t2;
            t2 = t2.next;
        }

        while(t1 != null && t2 != null){

            if(t1.val <= t2.val){
                ansTail.next = t1;
                ansTail = ansTail.next;
                t1 = t1.next;
            }
            else{
                ansTail.next = t2;
                ansTail = ansTail.next;
                t2 = t2.next;
            }
        }

        //If one of the list is empty then remaining list between t1 and t2 is already sorted
        if(t1 != null){
            ansTail.next = t1;
        }
        else{
            ansTail.next = t2;
        }

        return ansHead;        
    }
}