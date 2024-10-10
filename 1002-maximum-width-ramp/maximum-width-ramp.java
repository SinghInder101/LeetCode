class Solution {
    public int maxWidthRamp(int[] nums) {
        int maxRight [] = new int [nums.length];
        int max = 0;

        for(int i = nums.length - 1 ; i>=0 ; i--){
            if(nums[i] >= max){
                maxRight[i] = nums[i];
                max = nums[i];
            }
            else{
                maxRight[i] = max;
            }
     

        }
        int left = 0;
        int ans =0;
        for(int right = 0 ; right<nums.length ; right++){
            System.out.println(maxRight[right]);

            while(nums[left] > maxRight[right]){
                left++;
            }
            ans = Math.max(ans,right-left);
            
            
      
        }
        return ans;
       

        

       
        
    }
}