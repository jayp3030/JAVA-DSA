// Given the head of a singly linked list where elements are sorted in ascending order, convert it to a 
// height-balanced
// binary search tree.

// Example 1:
// Input: head = [-10,-3,0,5,9]
// Output: [0,-3,9,-10,null,5]
// Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.

// Example 2:
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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    ArrayList<Integer> list = new ArrayList<>();

    public TreeNode sortedListToBST(ListNode head) {
        ListNode currentNode = head;

        while (currentNode != null) {
            list.add(currentNode.val);
            currentNode = currentNode.next;
        }

        if (list.size() == 0)
            return null;
        return createBST(list, 0, list.size() - 1);
    }

    private TreeNode createBST(ArrayList list, int start, int end) {
        if (start > end) // base condition
            return null;
        // if we create BST for sorted list then it generate linkedlist so we find mid of list and recursivly generate BST
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode((int) (list.get(mid)));

        root.left = createBST(list, start, mid - 1);
        root.right = createBST(list, mid + 1, end);

        return root;
    }
}