// Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

// According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

//  Example 1:
// Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
// Output: 6
// Explanation: The LCA of nodes 2 and 8 is 6.

// Example 2:
// Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
// Output: 2
// Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

// Example 3:
// Input: root = [2,1], p = 2, q = 1
// Output: 2

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


 
// If the given both nodes values are less than that of root, then both the nodes must be on the left side of the root , so now we have to check only left tree of the root.
// Otherwise If the given both nodes values are greater than that of root, then both the nodes must be on the right side of the root , so now we have to check only right tree of the root.
// Otherwise . both the nodes will be on the either side of the root, this implies the lowest common ancestor is root.

 class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        else if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        else{
            return root;
        }
    }
}