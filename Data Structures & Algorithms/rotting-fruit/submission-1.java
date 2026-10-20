class Solution {
    public int orangesRotting(int[][] grid) {
        
        /**
        BFS Solution that turns levels into minutes, initially visits found
        rotten fruit, then only continues on fresh fruit to make rotten.

        Time Complexity: O(R x C) - Requires scanning of the entire grid
        Space Complexity: O(R x C) - Requires the grid
        **/

        int minutes = 0;
        int fresh = 0;

        Queue<int[]> q = new ArrayDeque<>();

        // Step 1: Find all initially rotten oranges
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {

                if (grid[row][col] == 2) {
                    q.offer(new int[] {row, col});
                } else if (grid[row][col] == 1) {
                    fresh += 1;
                }

            }
        }


        // Step 2: BFS from rotten oranges with levels as minutes
        while (!q.isEmpty() && fresh > 0) {

            int minuteSize = q.size();

            // Handle the minute
            for (int i = 0; i < minuteSize; i++) {
                
                int[] cell = q.poll();
                int row = cell[0];
                int col = cell[1];

                int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

                // Handle all potential directions
                for (int[] dir : dirs) {

                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    // Check if out-of-bounds or not a fresh fruit
                    if (newRow >= grid.length || newRow < 0 ||
                    newCol >= grid[0].length || newCol < 0 ||
                    grid[newRow][newCol] == 0 || grid[newRow][newCol] == 2) {
                        continue;
                    }

                    grid[newRow][newCol] = 2;
                    fresh--;

                    q.offer(new int[] {newRow, newCol});
                }

            }

            minutes++;

        }

        // If fresh == 0, return minutes, else return -1
        return fresh == 0 ? minutes : -1;

    }
}
