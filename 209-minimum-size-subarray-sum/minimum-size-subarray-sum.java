class Solution {
    public int minSubArrayLen(int target, int[] nums) { 
        int sum = 0;
        int left =0;
        int right =0;
        int length = Integer.MAX_VALUE;
        for(int i = 0; i<nums.length ; i++){
            sum += nums[i];
            right++;
            while(sum>=target){
                length = Math.min(length,(right-left));
                sum -= nums[left];
                left++;

            }
        }
        if(length == Integer.MAX_VALUE)
{
return 0;
}        return length;

        }
        
    }
