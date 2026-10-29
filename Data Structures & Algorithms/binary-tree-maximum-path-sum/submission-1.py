# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    """
    Time Complexity: O(n) - We have to visit each node
    Space Complexity: O(h) - Basic tree DFS stuff
    """
    
    # Our current max path sum. Changes as we go.
    result = 0

    def maxPathSum(self, root: Optional[TreeNode]) -> int:

        self.result = root.val

        # Creates no-split paths.
        def dfs(root):

            if not root:
                return 0
            
            # Basically creates the highest sum no-split paths on each side
            leftMax = max(dfs(root.left), 0) # We can have negative nodes, so just set to 0 if the entire subtree is just lowering things (not picking it)
            rightMax = max(dfs(root.right), 0)

            # Because we know leftMax and rightMax have no splits, we can try a split and see if it is the max
            # Note that if a leftMax or rightMax is 0, we're actually not even splitting, we're just continuing to no-split through the tree
            self.result = max(self.result, root.val + leftMax + rightMax)
            
            return root.val + max(leftMax, rightMax)
        
        dfs(root) # Run it to change the result global var
        return self.result

        
        
        
        