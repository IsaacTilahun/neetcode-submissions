# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
        """
        Time Complexity: We visit each node at most once, so it becomes O(n)
        
        Space Complexity: Recursion stack only needs to remember the chain of function
        calls that haven't returned yet, which would just be the current path through the
        tree (DFS). So, this comes out to O(h)
        """

        """
        Helper function that essentially does a DFS
        through the BST while keeping track of its allowed
        range
        """
        def validBST(node, low, high) -> bool:

            # Empty nodes are just seen as valid
            if not node:
                return True
            
            # Check if node is in valid range
            if not (low < node.val < high):
                return False

            # Check if node's left and right are both valid BSTs under their
            # new respective ranges
            return (
                validBST(node.left, low, node.val) and
                validBST(node.right, node.val, high)
            )
        
        # Call the helper with a starting range of (-inf, inf)
        return validBST(root, float("-inf"), float("inf"))
            
            
        

        
        
        

        