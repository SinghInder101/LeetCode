class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int visited[][] = new int[m][n];
        int islandCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] != 1 && grid[i][j] == '1') {
                    visited[i][j] = 1; // If curr is an island and not visited perform bfs on it
                    bfs(visited, grid, i, j);
                    islandCount++;

                }
            }
        }
        return islandCount;

    }

    public void bfs(int[][] visited, char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        visited[i][j] = 1;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(i, j));
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();
            for (int[] dir : directions) {
                int nx = row + dir[0];
                int ny = col + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == '1' && visited[nx][ny] == 0) {
                    visited[nx][ny] = 1;
                    q.add(new Pair(nx, ny));
                }

            }

        }
    }
}