class Solution {
    
    /**
    Time Complexity: O(R x C), just because we have to scan every coordinate
    Space Complexity: O(R x C), just cause at the end of the day we have the grid

    Essentially the idea is just scan every element of the grid, and do three possible things
    
    Water -> Simply mark coordinate as 'v' which is for visited coordinates
    Land -> Add one to the number of islands, and do a DFS through the neighboring land
    coordinates to mark as 'v' 
    Already Visited ('v') -> Skip
    */

    public int numIslands(char[][] grid) {
        
        int result = 0;

        for (int row = 0; row < grid.length; row++) {
            
            for (int col = 0; col < grid[0].length; col++) {

                String pos = row + "," + col;

                if (grid[row][col] == '1') {

                    result++;
                    dfs(grid, row, col);

                }

                grid[row][col] = 'v';
            }
        }

        return result;


    }

    private void dfs(char[][] grid, int row, int col) {

        // Check if element is out-of-bounds
        if (row < 0 || row >= grid.length ||
            col < 0 || col >= grid[0].length) {
                return;
            }

        String pos = row + "," + col;

        // Check if water or visited
        if (grid[row][col] == '0' || grid[row][col] == 'v') {
            
            grid[row][col] = 'v'; // In case its unvisited water
            return;
        }
        

        // Set coordinate as visited 
        grid[row][col] = 'v';

        // Visit neighbours
        dfs(grid, row+1, col);
        dfs(grid, row-1, col);
        dfs(grid, row, col+1);
        dfs(grid, row, col-1);
    }
}
