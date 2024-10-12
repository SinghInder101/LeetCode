class Solution {
    public boolean canJump(int[] nums) {

        boolean dp[] = new boolean [nums.length];
        dp[nums.length-1] = true;

        for(int i=nums.length - 2 ; i>=0 ; i--){

            for(int j = 1 ; j<=nums[i] ; j++){

                if(i+j < nums.length){
                    if(dp[i+j] == true){
                        dp[i] = true;
                    }
                    
                }

            }


        }
        return dp[0];

        
    }
}