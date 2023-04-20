// Given the root of a binary tree, return the maximum width of the given tree.

// The maximum width of a tree is the maximum width among all levels.

// The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.

// It is guaranteed that the answer will in the range of a 32-bit signed integer.

// Example 1:
// Input: root = [1,3,2,5,3,null,9]
// Output: 4
// Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).

// Example 2:
// Input: root = [1,3,2,5,null,null,9,6,null,7]
// Output: 7
// Explanation: The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).

// Example 3:
// Input: root = [1,3,2,5]
// Output: 2
// Explanation: The maximum width exists in the second level with length 2 (3,2).

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
    public int widthOfBinaryTree(TreeNode root) {
        Deque<TreeNode> queue=new ArrayDeque<>();
        root.val=0;
        queue.add(root);
        return bfs(queue);
    }
    
    public int bfs(Deque<TreeNode> queue){
        int maxWidth = 1;
        while(!queue.isEmpty()){
            int s=queue.size();
            int left = queue.peek().val;
            int right = left;
            for(int i=0;i<s;i++){
                TreeNode node=queue.removeFirst();           
                
                if(node.left!=null){
                    node.left.val = node.val * 2 - 1;
                    queue.add(node.left);
                }
                if(node.right!=null){
                    node.right.val = node.val * 2;
                    queue.add(node.right);
                }
                if(i==s-1)
                    right=node.val;
            }
            maxWidth=Math.max(maxWidth,right-left+1);
        }
        return maxWidth;
    }
}