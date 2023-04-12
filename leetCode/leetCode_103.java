// Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

// Example 1:
// Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[20,9],[15,7]]

// Example 2:
// Input: root = [1]
// Output: [[1]]

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        int level = 0;

        q.add(root);

        while(!q.isEmpty()){
            
            int qSize = q.size();
            
            List<Integer> subRes = new ArrayList<>();

            for(int i = 0 ; i < qSize ; i++){
                TreeNode curr = q.remove();
                if(curr != null){
                    subRes.add(curr.val);
                    q.add(curr.left);
                    q.add(curr.right);
                }
            }

            if(!subRes.isEmpty()){
                if( level % 2 != 0 ){     // odd levels
                    Collections.reverse(subRes);
                }
                res.add(subRes);
            }
            level++;
        }

        return res;
    }
}