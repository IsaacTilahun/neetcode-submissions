# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:

        c1 = l1
        c2 = l2
        carry = 0
        head = ListNode()
        prev = None
        curr = head

        """
        Time Complexity: O(n) - one quick pass through linked list
        Space Complexity: O(n) - just need to store l1, l2, and curr

        The idea is essentially you remember the carry and add it to the
        next node. It's like addition where you just bring the carry over
        and add it to the sum of the digits at whatever 1s 10s 100s you are working with.

        If there are no more nodes but there is something to carry, that means there is still
        an extra digit to work with.

        TLDR: think of it like how you manually do addition by hand
        """

        while (c1 or c2 or carry):
            
            val1 = c1.val if c1 else 0
            val2 = c2.val if c2 else 0

            node_sum = val1 + val2 + carry

            curr.val = node_sum % 10
            carry = node_sum // 10

            curr.next = ListNode()
            prev = curr
            curr = curr.next

            if (c1):
                c1 = c1.next
            if (c2):
                c2 = c2.next
        
        prev.next = None # removing that last node from things
        
        return head

                


        