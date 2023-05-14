// Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
// The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).

//  Example 1:
// Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
// Output: 3
// Explanation: The paths that sum to 8 are shown.

// Example 2:
// Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
// Output: 3

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
    List<TreeNode> list = new ArrayList<>();
    int ans = 0;
    public int pathSum(TreeNode root, int targetSum) {

        if(root == null) return 0;

        inorder(root);

        for( TreeNode node : list){
            long sum = 0;
            helper(node , sum , targetSum);
        }

        return ans;
        
    }
    private void inorder(TreeNode root){
        if(root == null) return;

        list.add(root);
        inorder(root.left);
        inorder(root.right);
    }
    private void helper(TreeNode root , long sum , int targetSum ){
        if(root == null) return;

        sum += root.val;
        if( sum == targetSum) ans++;

        helper(root.left , sum  , targetSum);
        helper(root.right , sum , targetSum);

        sum -= root.val; // while backtracking
    }
}