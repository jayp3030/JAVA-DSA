// Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.

// Example 1:
// Input: root = [4,2,6,1,3]
// Output: 1

// Example 2:
// Input: root = [1,0,48,null,null,12,49]
// Output: 1

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private Integer prev;
    private int minDiff;
    public int getMinimumDifference(TreeNode root) 
    {
        prev = null;
        minDiff = Integer.MAX_VALUE;
        inorderTraversal(root);
        return minDiff;
    }
    private void inorderTraversal(TreeNode node) 
    {
        if (node == null) 
        {
            return;
        }

        inorderTraversal(node.left);

        if (prev != null) 
        {
            minDiff = Math.min(minDiff, node.val - prev);
        }
        prev = node.val;

        inorderTraversal(node.right);
    }
}