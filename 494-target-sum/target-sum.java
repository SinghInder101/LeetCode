class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int a = helper(nums,0,target);

       if (a > 0) {
    return a;
} else {
    return 0;
}






        
    }

    public int helper(int[] nums,int i,int target){
        if(i==nums.length ){
            if(target == 0){
                return 1;
            }
            return -1;
        }

        int negative = helper(nums,i+1, target+nums[i]);
        int positive = helper(nums,i+1,target-nums[i]);

        if(negative>0 && positive>0){
            return negative+positive;
        }
        if(negative > 0){
            return negative;
        }
        return positive;





    }
}