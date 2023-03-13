// Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

// Example 1:
// Input: root = [1,2,2,3,4,4,3]
// Output: true

// Example 2:
// Input: root = [1,2,2,null,3,null,3]
// Output: false

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
    public boolean isSymmetric(TreeNode root) {
        if( root == null)
            return true;

        return isMirror(root.left , root.right);
    }
    private boolean isMirror(TreeNode leftNode , TreeNode rightNode){
        if(leftNode == null && rightNode == null){
            return true;
        }
        else if(leftNode == null || rightNode == null){      // one of node is null 
            return false;
        }

        if( leftNode.val != rightNode.val){
            return false;
        }

        if( !isMirror(leftNode.left , rightNode.right))
            return false;
        if( !isMirror(leftNode.right , rightNode.left))
            return false;
        
        return true;
    }
}