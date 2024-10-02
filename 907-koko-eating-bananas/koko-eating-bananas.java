class Solution {
    public int minEatingSpeed(int[] piles, int h) {

          // Initialize max and min values to the first element in the array
        int maxValue = piles[0];
        int sum = 0;

        // Loop through the array to find the maximum, minimum values, and calculate the sum
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > maxValue) {
                maxValue = piles[i];
            }
            sum += piles[i];
           
        }
        int si= (int)Math.ceil((double) sum/(double) h);

        if(piles.length == h ){
            return maxValue;
        }
      int low = si, high = maxValue;

      while(low<=high){
        int mid = (high+low)/2;

        int totalHours = helper(piles,mid);
        if(totalHours <= h){
            high  = mid-1;
        }else{
            low=mid+1;

        }


      }
      return low;
       
        
        
    }
    public int helper(int[] piles, int currSpeed){
        int totalHours = 0;
        for(int i = 0; i<piles.length ; i++){

            totalHours += Math.ceil((double) piles[i]/(double) currSpeed);




        }
        return totalHours;
    }
}