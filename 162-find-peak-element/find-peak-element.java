class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1) return 0;

        return binarySearch(0,nums.length-1,nums);
    }

    int binarySearch(int l , int r ,int[] nums){
        int mid = l+(r-l)/2;
    
        if(mid ==0 ){
            return nums[mid+1]<nums[mid]?mid:mid+1;
        }

        if(mid ==nums.length-1 && nums[mid-1]<nums[mid]){
            return mid;
        }

        if(nums[mid-1] <nums[mid] && nums[mid+1]<nums[mid]){
            return mid;
        }

        if(nums[mid-1]>nums[mid]) {
            return binarySearch(l,mid,nums);
        } else {
             return binarySearch(mid+1,r,nums);
        }
    }
}