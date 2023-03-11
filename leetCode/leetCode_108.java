// Given an integer array nums where the elements are sorted in ascending order, convert it to a 
// height-balanced
// binary search tree.

// Example 1:
// Input: nums = [-10,-3,0,5,9]
// Output: [0,-3,9,-10,null,5]
// Explanation: [0,-10,5,null,-3,null,9] is also accepted:

// Example 2:
// Input: nums = [1,3]
// Output: [3,1]
// Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.

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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)
            return null ;
        return createBST(nums , 0 , nums.length-1);
    }

    private TreeNode createBST(int nums[] , int start , int end){
        if(start > end){        // base condition
            return null;
        }
        
        // if we create BST for sorted array it generate Linkedlist so to make height balanced tree we take middle of array and make it root and continuously build tree 
        int mid = (start+end)/2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = createBST( nums , start , mid-1);
        root.right = createBST( nums , mid+1 , end);

        return root;
    }
}