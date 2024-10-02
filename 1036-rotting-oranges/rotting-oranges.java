import java.util.LinkedList;
import java.util.Queue;

class Solution {
    
    /**
     * Main function to calculate the minimum minutes until no fresh oranges remain.
     *
     * @param grid 2D array representing the grid of oranges.
     * @return Minimum number of minutes to rot all fresh oranges, or -1 if impossible.
     */
    public int orangesRotting(int[][] grid) {
        // Initialize the grid and count fresh oranges
        InitializationResult initResult = initializeGrid(grid);
        Queue<int[]> queue = initResult.queue;
        int freshCount = initResult.freshCount;

        // If there are no fresh oranges, return 0 minutes
        if (freshCount == 0) {
            return 0;
        }

        int minutes = 0;
        // Define the four possible directions (up, down, left, right)
        int[][] directions = { {1,0}, {-1,0}, {0,1}, {0,-1} };

        // Perform Breadth-First Search (BFS) to rot adjacent fresh oranges
        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();
            // Process all rotten oranges at the current minute
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];

                // Check all four directions for fresh oranges
                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    // If the adjacent cell is within bounds and has a fresh orange
                    if (isValid(newRow, newCol, grid)) {
                        // Rot the fresh orange
                        grid[newRow][newCol] = 2;
                        freshCount--;
                        // Add the newly rotten orange to the queue
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
            // Increment minutes after processing the current level
            minutes++;
        }

        // If all fresh oranges are rotted, return the minutes elapsed
        return freshCount == 0 ? minutes : -1;
    }

    /**
     * Helper function to initialize the grid.
     * It adds all initially rotten oranges to the queue and counts fresh oranges.
     *
     * @param grid 2D array representing the grid of oranges.
     * @return An InitializationResult containing the queue of rotten oranges and the count of fresh oranges.
     */
    private InitializationResult initializeGrid(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        // Iterate through each cell in the grid
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    // Add positions of initially rotten oranges to the queue
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    // Count the number of fresh oranges
                    freshCount++;
                }
            }
        }

        return new InitializationResult(queue, freshCount);
    }

    /**
     * Helper function to check if a cell is within grid bounds and has a fresh orange.
     *
     * @param row  Row index of the cell.
     * @param col  Column index of the cell.
     * @param grid 2D array representing the grid of oranges.
     * @return True if the cell is valid and has a fresh orange, otherwise false.
     */
    private boolean isValid(int row, int col, int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        return (row >= 0 && row < rows) &&
               (col >= 0 && col < cols) &&
               (grid[row][col] == 1);
    }

    /**
     * Helper class to store the result of the grid initialization.
     */
    private class InitializationResult {
        Queue<int[]> queue;
        int freshCount;

        InitializationResult(Queue<int[]> queue, int freshCount) {
            this.queue = queue;
            this.freshCount = freshCount;
        }
    }
}
