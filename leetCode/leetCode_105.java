// Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

// Example 1:

// Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
// Output: [3,9,20,null,null,15,7]

// Example 2:

// Input: preorder = [-1], inorder = [-1]
// Output: [-1]

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;

        return helper(preorder,inorder, 0 , len-1 , 0 , len-1);
    }
    private TreeNode helper(int[] preorder , int[] inorder , int preStart , int preEnd , int inStart , int inEnd){

        if(inStart > inEnd){    // base condition
            return null;
        }

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = inStart;

        for( ; rootIndex < inEnd ; rootIndex++){
            if(inorder[rootIndex] == rootVal){      // here we getting root from inorder array
                break;
            }
        }
        
        // getting size of left and right subtree
        int leftSTreeSize = rootIndex - inStart;
        int rightSTreeSize = inEnd - rootIndex;

        //first we divide our problem in small problem so we can now use recursion to generate binary tree

        root.left = helper(preorder , inorder , preStart+1 , preEnd-rightSTreeSize, inStart , rootIndex-1) ;
        root.right = helper(preorder , inorder , preStart+leftSTreeSize+1 , preEnd , rootIndex+1 , inEnd);

        return root;
    }
}