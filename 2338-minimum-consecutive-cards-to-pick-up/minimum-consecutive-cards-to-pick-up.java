class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int minAns = Integer.MAX_VALUE;
        for(int i = 0 ; i<cards.length ; i++){
            if(map.containsKey(cards[i])){
               if(i- map.get(cards[i]) +1<minAns){
                minAns = i- map.get(cards[i])+1;
                
               }
               
            }
           
                map.put(cards[i],i);
            
        }
        if(minAns == Integer.MAX_VALUE){
            return -1;
        }
        return minAns;
        
    }
}