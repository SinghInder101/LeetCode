class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int r = 1;
        int currSum = 0;
        int maxLength = Integer.MAX_VALUE;
        for (int i = l; i < nums.length; i++) {
            currSum += nums[i];
            if (i + 1 - l < maxLength && currSum >= target) {
                maxLength = i + 1 - l;
            }
            while (currSum >= target) {
                 if (i + 1 - l < maxLength && currSum >= target) {
                maxLength = i + 1 - l;
            }
                currSum = currSum - nums[l++];
            }

        }
        if( maxLength == Integer.MAX_VALUE){
            return 0;
        }
        return maxLength;
    }
}