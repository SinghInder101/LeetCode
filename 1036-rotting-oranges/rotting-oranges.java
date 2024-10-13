class Pair {
     int row;
     int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;


        Queue<Pair> q = new LinkedList<Pair>();
        int countFresh = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                } else if (grid[i][j] == 1) {
                    countFresh++;

                }

            }

        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int time =0;
        if(countFresh == 0){
            return 0;
        }

        while(!q.isEmpty()){
       
            int size = q.size();
            boolean flag = false;
            for(int i = 0 ; i<size ;i++){
                
                Pair rottenOrange = q.poll();
                for(int [] dir: dirs){
                    int nx = rottenOrange.row + dir[0];
                    int ny = rottenOrange.col + dir[1];
                    if(nx>=m || ny >=n || nx<0 || ny<0 || grid[nx][ny] == 0 || grid[nx][ny] == 2){
                        continue;
                    }
                    flag= true;

                    grid[nx][ny] = 2;
                    q.add(new Pair(nx, ny));
                    countFresh--;
                }

            }
            if(flag == true){
                time++;
            }

            

        
        }
        if(countFresh == 0){
            return time;
        }
        return -1;

    }
}