// Given the root of a binary tree, return the inorder traversal of its nodes' values.
 
// Example 1:

// Input: root = [1,null,2,3]
// Output: [1,3,2]
// Example 2:

// Input: root = []
// Output: []
// Example 3:

// Input: root = [1]
// Output: [1]

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
// ------------------------------------- recursive approach ---------------------------------------------- 
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        tree(root , result);

        return result;
       
    }

    public void tree(TreeNode root , List<Integer> result){
        if(root == null){
            return ;
        }

        tree(root.left , result);
        result.add(root.val);
        tree(root.right , result);
    }
}


// -------------------------------------- iterative approach ------------------------------------------- 

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> tovisit = new Stack<>();

        TreeNode curr = root;

        while( curr != null || !tovisit.isEmpty()){
          // in inorder - left root right
          // so first we push all the left node of root 
          while(curr != null){
            tovisit.push(curr);
            curr = curr.left;
          }
          // now on the top of stack last leftnode so we pop it and add to res
          curr = tovisit.pop();
          res.add(curr.val);
          curr = curr.right;
        }
        return res;
        
       
    }
}