// Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

// Example 1:
// Input: root = [1,2,3,null,5,null,4]
// Output: [1,3,4]

// Example 2:
// Input: root = [1,null,3]
// Output: [1,3]

// Example 3:
// Input: root = []
// Output: []

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if( root == null) return res;

        List<TreeNode> members = new LinkedList<>();        // to track node of same level
        members.add(root);

        while(!members.isEmpty()){
            List<TreeNode> temp = new LinkedList<>();       // using it to update members

            // get(0) because we are storing right node first every time
            res.add(members.get(0).val);                    // actual result will be added 

            for(TreeNode curr : members){
                if(curr.right != null){
                    temp.add(curr.right);
                }
                if(curr.left != null){
                    temp.add(curr.left);
                }
            }

            members = temp;

        }

        return res;
    }
}