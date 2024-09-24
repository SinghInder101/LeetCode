class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length-1;
        while(l<r){
            int currSum = numbers[l]+numbers[r];
            if(currSum>target){
                r--;
                continue;
            }
            if(currSum<target){
                l++;
                continue;
            }
            if(currSum == target){
                int ans []= new int [2];
                ans[0] = l+1;
                ans[1] = r+1;
                return ans;
            }

        }
        return null;

        
    }
}