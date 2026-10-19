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

    private int preIndex;
    private HashMap<Integer, Integer> inIndex;
    
    /**
    Time Complexity: O(n), scans over the inorder list once, then just visits all nodes
    
    Space Complexity: O(n), has to hold all of the nodes, then also as to handle O(h) in stack space
    when creating the actual tree
    */

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        inIndex = new HashMap<>();

        for (int i = 0; i < preorder.length; i++) {
            inIndex.put(inorder[i], i); // Key inorder[i] so you can obtain index using value, we split on them.
        }

        return dfs(preorder, 0, preorder.length-1);
    }

    private TreeNode dfs(int[] preorder, int left, int right) {

        // We are in an invalid chunk of the inorder list
        if (left > right) {
            return null;
        }

        // Create root node
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        int pivot = inIndex.get(rootVal);

        root.left = dfs(preorder, left, pivot-1);
        root.right = dfs(preorder, pivot+1, right);

        return root;

    }
}
