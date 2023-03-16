// Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

// Example 1:
// Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
// Output: [3,9,20,null,null,15,7]

// Example 2:
// Input: inorder = [-1], postorder = [-1]
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;

        return helper(inorder , postorder , 0 , len-1 , 0 , len-1);
        // 0 - start of inorder or postorder
        // len - 1 - end of inorder or postorder
    }
    private TreeNode helper( int[] inorder , int[] postorder , int inStart , int inEnd , int postStart , int postEnd){
        if(inStart > inEnd ){
            return null;
        }

        int rootVal = postorder[postEnd];               
        TreeNode root = new TreeNode( rootVal );

        int rootIndex = inStart;

        for( ; rootIndex < inEnd ; rootIndex++){        // to find index of every root 
            if( inorder[rootIndex] == rootVal){
                break;
            }
        }

        // after knowing root we can find left and right subtrees using inorder array for that..

        int leftTreeSize = rootIndex - inStart;
        int rightTreeSize = inEnd - rootIndex;

        //first we divide our problem in small problem so we can now use recursion to generate binary tree

        root.left = helper( inorder , postorder , inStart , rootIndex-1 , postStart , postStart + leftTreeSize -1);
        root.right = helper( inorder , postorder , rootIndex+1 , inEnd , postEnd - rightTreeSize , postEnd - 1  );
        return root;
    }
}