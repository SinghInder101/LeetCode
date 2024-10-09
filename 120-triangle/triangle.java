class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
    
       int m = triangle.size();
       int n = triangle.get(0).size();

       Integer dp [][] = new Integer [m][triangle.get(triangle.size()-1).size()];

   
        return (int) helper(triangle,0,0,m,n,dp);
       


        
    }
    public Integer helper(List<List<Integer>> triangle,int i , int j , int m , int n,Integer dp [] []){

       
       if(i+1 >= m){
        return triangle.get(i).get(j);

       }
        int bottom;
        int diagonal;
          if(dp[i+1][j] != null){
            bottom = dp[i+1][j];
          }
          else{
            
          bottom = helper(triangle,i+1,j,m,triangle.get(i).size(),dp);
          }
           if(dp[i+1][j+1] != null){
            diagonal = dp[i+1][j+1];
          }
          else{
          diagonal = helper(triangle,i+1,j+1,m,triangle.get(i).size(),dp);

          }
       

        dp[i][j] = Math.min(bottom,diagonal)+ triangle.get(i).get(j);
        return dp[i][j];
    }


}