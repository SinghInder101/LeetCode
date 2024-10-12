class Solution {
    public int maxProfit(int[] prices) {
        int buyIndex = 0 ;
        int sellIndex = 1;
        int profit = Integer.MIN_VALUE;
        while(buyIndex<sellIndex && sellIndex< prices.length){
            int currProfit = prices[sellIndex] - prices[buyIndex];
            if(currProfit>0){
                sellIndex++;
                if(currProfit>profit){
                    profit = currProfit;
                }
            }
            else{
                buyIndex = sellIndex;
                sellIndex++;
            }
            

        }
        if(profit ==  Integer.MIN_VALUE){
            return 0;
        }
        return profit;
        
    }
}