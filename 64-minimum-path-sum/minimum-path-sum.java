class Solution {
    public int minPathSum(int[][] grid) {
        //This is a DP question due to overlapping subproblems

        int dp[][] = new int [grid.length+1][grid[0].length+1];
        for(int i = 0 ; i<dp.length ; i++){
            dp[i][0] = Integer.MAX_VALUE;
        }
        for(int i = 0 ; i<dp[0].length ; i++){
            dp[0][i] = Integer.MAX_VALUE;
        }
        dp[1][1]=grid[0][0];
        

        for(int i = 1 ; i< dp.length ; i++){
            for(int j = 1; j< dp[0].length ; j++){
                if(i == 1 && j ==1){
                    continue;
                }

                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i-1][j-1];
                System.out.println(dp[i][j]);


            }
        }
        return dp[dp.length - 1][dp[0].length - 1];  // Correct return statement

        
    }
}