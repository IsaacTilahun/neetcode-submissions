class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        
        """
        Time Complexity: O(m x n) - Just comes from the fact that you have to pass every cell,
        and memoization stores the paths to a cell after its calculated once.

        Space Complexity: O(m x n) - The grid

        The idea is essentially go top-down with memoization. The amount of paths to a cell
        is the amount to the cell above plus the amount to the cell to the left. So, we solve
        for these values recursively and just save to avoid repeated calculations.

        0,0 has one path because you start there

        Anything on the top side and left side just has one just because you simply
        can either spam rightwards or spam downwards to get there, no way else
        """
        
        dp = [[-1] * n for _ in range(m)]

        def upRec(r: int, c: int) -> int:

            if dp[r][c] != -1:
                return dp[r][c]
            
            if r == 0 and c == 0:
                return 1
            elif r == 0:
                dp[r][c] = upRec(r,c-1)
            elif c == 0:
                dp[r][c] = upRec(r-1,c)
            else:
                dp[r][c] = upRec(r-1,c) + upRec(r,c-1)
            
            return dp[r][c]
        
        return upRec(m-1, n-1)
        