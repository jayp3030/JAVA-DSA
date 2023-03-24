// Given the root of a binary tree, return the preorder traversal of its nodes' values.

// Example 1:
// Input: root = [1,null,2,3]
// Output: [1,2,3]

// Example 2:
// Input: root = []
// Output: []

// Example 3:
// Input: root = [1]
// Output: [1]

// ------------------------------------------ iterative approach --------------------------------------------- 

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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if(root == null) return res;

        Stack<TreeNode> tovisit = new Stack<>();
        tovisit.push(root);
        while( ! tovisit.empty()){
            
            TreeNode visitedNode = tovisit.pop();
            res.add(visitedNode.val);
            
            // in preorder - root left right
            // so first we add right in stack and then left beause stack is LIFO..
            if(visitedNode.right != null) tovisit.push(visitedNode.right);
            if(visitedNode.left != null ) tovisit.push(visitedNode.left);
        }
        return res;
    }
}

// ------------------------------------------------ recursive approach ------------------------------------------------ 

public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> res = new LinkedList<>();
    preHelper(root,res);
    return res;
}
public void preHelper(TreeNode root, List<Integer> res) {
    if(root==null) return;
    pre.add(root.val);
    preHelper(root.left,res);
    preHelper(root.right,res);
}