# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        
        """
        Time Complexity: O(h + k) - it really just depends on what k is, if k is 1 then we just traverse the smallest path
        and we immediately have our answer
        Space Complexity: O(h) - Yeah just a DFS through a BST.
        """

        n = 0
        stack = []
        curr = root

        while curr or stack:

            while curr:
                stack.append(curr)
                curr = curr.left
            
            curr = stack.pop()
            n += 1
            if n == k:
                return curr.val

            curr = curr.right
        
        return
