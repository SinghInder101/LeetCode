class Solution {
    public int trap(int[] height) {
        int leftMax [] = new int [height.length];
        int rightMax [] = new int [height.length];

 
       rightMax[height.length - 1] = height[height.length -1];
        for(int i =height.length -2; i >=0 ; i--){
            rightMax[i] = Math.max(rightMax[i+1],height[i]); 

        }
        leftMax[0] = height[0];
        int water = 0;


        for(int i = 1;  i<height.length ; i++){
            leftMax[i] = Math.max(leftMax[i-1],height[i]); 
            int currWater = Math.min(rightMax[i],leftMax[i]) - height[i];

            water += currWater;

        }
        return water;
        
    }
}