class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
    
       int m = triangle.size();
       int n = triangle.get(0).size();

       int dp [][] = new int [m][triangle.get(triangle.size()-1).size()];

      for (int i = 0; i < dp.length; i++) {
    Arrays.fill(dp[i], Integer.MAX_VALUE);
}
        return helper(triangle,0,0,m,n,dp);
       


        
    }
    public int helper(List<List<Integer>> triangle,int i , int j , int m , int n,int dp [] []){

       
       if(i+1 >= m){
        return triangle.get(i).get(j);

       }
        int bottom;
        int diagonal;
          if(dp[i+1][j] != Integer.MAX_VALUE){
            bottom = dp[i+1][j];
          }
          else{
            
          bottom = helper(triangle,i+1,j,m,triangle.get(i).size(),dp);
          }
           if(dp[i+1][j+1] != Integer.MAX_VALUE){
            diagonal = dp[i+1][j+1];
          }
          else{
          diagonal = helper(triangle,i+1,j+1,m,triangle.get(i).size(),dp);

          }
       

        dp[i][j] = Math.min(bottom,diagonal)+ triangle.get(i).get(j);
        return dp[i][j];
    }


}