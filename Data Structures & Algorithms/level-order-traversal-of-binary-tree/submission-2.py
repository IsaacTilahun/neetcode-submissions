# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:

        """
        The idea is essentially using a BFS that tracks depth.

        We firstly create a queue then append the root. Then what
        we will do is run a while loop that goes through each depth.

        for _ in range(len(q)) allows us to ensure that we are only
        running through the nodes in the queue that are of the depth
        that we want, as len(q) is stuck the moment it is calcualted.

        In that for loop, for every node in the depth, we append its value to
        inner list level. After that, we append its child nodes, which will
        be went over in the next iteration of while q. After iterating through
        the entire depth in the for loop, we finally add this inner list to result.

        Time Complexity of O(n) as we still have to go through all nodes.
        
        Space Complexity of O(n) as we have to store every node at the lowest
        level at the same time, and as the tree gets bigger the lowest level
        gets bigger proportionally to n.
        """

        if not root:
            return []

        result = []
        q = collections.deque()
        q.append(root)

        while q:

            level = []

            for _ in range(len(q)):

                node = q.popleft()
                level.append(node.val)

                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            
            result.append(level)
        
        return result


            


        