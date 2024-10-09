class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp []= new int  [nums.length];
        int overallMAX = Integer.MIN_VALUE;

        for(int i = 0 ; i<dp.length ; i++){
            int max = 0;

            for(int j = 0 ; j<i ; j++){
                if(nums[i]>nums[j]){
                    if(dp[j] > max){
                        max = dp[j];
                    }
                }

            }
             dp[i] = max+1;
           
            overallMAX = Math.max(dp[i],overallMAX);
        }
         return overallMAX;
        
    }
   
}