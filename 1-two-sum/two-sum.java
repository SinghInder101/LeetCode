class Solution {
    public int[] twoSum(int[] nums, int target) {

        // Idea 1: sort the list, keep a left at the start and right pointer at the
        // end-> add -> if result is greater than what is required-> right--,else left++

        HashMap<Integer,Integer> map = new HashMap<Integer,Integer> ();
        int arr [] = new int [2];

        for(int i = 0 ; i<nums.length ; i++){
            if(map.containsKey(target-nums[i])){
               arr[0] = map.get(target-nums[i]);
                arr[1] = i;
                return arr;
            }
            map.put(nums[i],i);
        }
        return arr;

    }
}