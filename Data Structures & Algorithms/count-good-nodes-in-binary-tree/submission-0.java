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
    
    private int result;

    /**
    Simple DFS that checks if the new node is larger than the max of the path.
    If so, we have a good node. 


    Time Complexity: O(n), visits every node
    Space Complexity: O(h), only stores the path being actively ran at once
    */

    public int goodNodes(TreeNode root) {
        
        result = 0;

        dfs(root, root.val);

        return result;
    }

    private void dfs(TreeNode node, int max) {
        
        if (node == null) {
            return;
        }

        if (node.val >= max) {
            result++;
            max = node.val;
        }

        dfs(node.left, max);
        dfs(node.right, max);

    }
}
