class Solution {
    public int findPeakElement(int[] nums) {
        int left = 1;
        int right = nums.length-2;
        if(nums.length == 1){ //Agar ek length ka hai toh sidha return
            return 0;
        }
       if(nums[0]>nums[1]){
         //If the first element is greater than the second, it means it is a  maxima return it
        return 0;
       }
       if(nums[nums.length-1]>nums[nums.length-2]){
        //If the last element is greater thant the second last, it means it is the maxima return it.
        return nums.length-1;
       }


    //     If first and last both are not the answer, the answer must lie between them therefore
     // left = 1  and right = second_Last(nums.length-2)(line 4), we apply the bs in them
    return bs(nums,left,right);

        
    }
    public int bs(int[] nums, int left,int right){
        if(left<=right){
            int mid = (left+right)/2;

            // if(mid == 0){
            //     if(nums.length == 1){
            //         return 0;
            //     }
            //     else if(nums[mid] > nums[mid+1]){
            //         return 0;

            //     }
            //     else if(nums[mid+1] > nums[mid]){
            //         return mid+1;
            //     }

            // }
            // if(mid == nums.length-1){
            //     if(nums[mid] > nums[mid-1]){
            //         return mid;
            //     }
            //     else{
            //         return mid-1;
            //     }
            // }

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