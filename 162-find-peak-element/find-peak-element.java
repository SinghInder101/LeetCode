class Solution {
    public int findPeakElement(int[] nums) {
        int left = 1;
        int right = nums.length-2;
        if(nums.length == 1){
            return 0;
        }
       if(nums[0]>nums[1]){
        return 0;
       }
       if(nums[nums.length-1]>nums[nums.length-2]){
        return nums.length-1;
       }


        return bs(nums,left,right);

        
    }
    public int bs(int[] nums, int left,int right){
        if(left<=right){
            int mid = (left+right)/2;

            if(nums[mid-1] < nums[mid] && nums[mid+1] < nums[mid] ){
                return mid;
            }
            else{
                if(nums[mid-1] < nums[mid] && nums[mid+1] > nums[mid]){
                    return bs(nums,mid+1,right);
                }
                if(nums[mid-1]>nums[mid] && nums[mid+1] < nums[mid]){
                    return bs(nums,left,mid-1);
                }
                if(nums[mid-1] > nums[mid] && nums[mid+1] > nums[mid]){
                    return bs(nums,mid+1,right);
            }
            }

        }
        return -1;
    }
}