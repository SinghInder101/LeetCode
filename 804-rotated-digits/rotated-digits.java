class Solution {
    public int rotatedDigits(int n) {
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(1,1);
        map.put(0,0);
        map.put(8,8);
        map.put(2,5);
        map.put(5,0);
        map.put(6,9);
        map.put(9,6);
        
        for(int i = 1; i<=n; i++){
            int num = 0;
            int j = 0;
            int currNum = i;
            while(currNum > 0){
                int changedNum;
                if(map.containsKey(currNum%10)){
                    changedNum = map.get(currNum%10);
                }
                else{
                    break;
                }
                num = num + changedNum * (int)Math.pow(10, j);

                currNum = currNum/10;
                j++;
               if(currNum==0){
                if(num != i){
                    count++;
                }
                break;
               }


            }

        }
        return count;
    }
}