# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:

        stack = collections.deque()

        def dfs(root):
            
            if not root:
                return

            dfs(root.right)
            stack.append(root.val)
            dfs(root.left)

            return

        dfs(root)
        
        for _ in range(k-1):
            stack.pop()

        return stack.pop()



        