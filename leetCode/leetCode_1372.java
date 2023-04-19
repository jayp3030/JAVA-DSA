// You are given the root of a binary tree.

// A ZigZag path for a binary tree is defined as follow:

// Choose any node in the binary tree and a direction (right or left).
// If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
// Change the direction from right to left or from left to right.
// Repeat the second and third steps until you can't move in the tree.
// Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).

// Return the longest ZigZag path contained in that tree.

// Example 1:

// Input: root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]
// Output: 3
// Explanation: Longest ZigZag path in blue nodes (right -> left -> right).

// Example 2:

// Input: root = [1,1,1,null,1,null,null,1,1,null,1]
// Output: 4
// Explanation: Longest ZigZag path in blue nodes (left -> right -> left -> right).

// Example 3:

// Input: root = [1]
// Output: 0

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
    int max=0;
    public int longestZigZag(TreeNode root) {
       if (root == null) return -1;
        max = 0;
        helper(root.right, 1, true);
        helper(root.left, 1, false);
        return max;   
    }
     private  void helper(TreeNode root, int step, boolean isRight) {
        if (root == null) return;
        max = Math.max(max, step);
        if (isRight) {
            helper(root.left, step + 1, false);
            helper(root.right, 1, true);
        } else {
            helper(root.right, step + 1, true);
            helper(root.left, 1, false);
        }
    }
}