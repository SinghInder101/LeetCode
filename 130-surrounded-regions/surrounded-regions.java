class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        
        // Loop through all cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Only start DFS from 'O's that haven't been visited
                if (board[i][j] == 'O' && !visited[i][j]) {
                    // List to store the cells of the current region
                    List<int[]> region = new ArrayList<>();
                    boolean isEnclosed = helper(board, i, j, visited, region);
                    if (isEnclosed) {
                        // Flip all cells in the region to 'X'
                        for (int[] cell : region) {
                            board[cell[0]][cell[1]] = 'X';
                        }
                    }
                }
            }
        }
    }
    
    private boolean helper(char[][] board, int i, int j, boolean[][] visited, List<int[]> region) {
        int m = board.length;
        int n = board[0].length;
        
        // Check boundaries
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return false; // Reached boundary; region is not enclosed
        }
        
        if (board[i][j] == 'X' || visited[i][j]) {
            return true; // Current path is enclosed so far
        }
        
        visited[i][j] = true;
        region.add(new int[]{i, j});
        
        // Recursively check all four directions
        boolean up = helper(board, i - 1, j, visited, region);
        boolean down = helper(board, i + 1, j, visited, region);
        boolean left = helper(board, i, j - 1, visited, region);
        boolean right = helper(board, i, j + 1, visited, region);
        
        // If all directions are enclosed, return true
        return up && down && left && right;
    }
}
