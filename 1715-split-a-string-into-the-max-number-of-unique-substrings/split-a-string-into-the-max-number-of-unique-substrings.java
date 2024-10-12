class Solution {
    public int maxUniqueSplit(String s) {
        HashSet<String> myHashSet = new HashSet<>();
        return helper(s,myHashSet,0);

    }



    public int helper(String s, HashSet<String> set,int i){

        if(i == s.length()){
            return 0;
        }




        int maxAns = -1;



        for(int end=i+1 ; end<=s.length(); end++){

           if (!set.contains(s.substring(0,end)) ){

            set.add(s.substring(0,end));

             int ans = helper(s.substring(end),set,0) + 1;
             set.remove(s.substring(i,end));

             if(ans>maxAns){
                maxAns = ans;
             }


           }

            

        }
        return maxAns;


    }
}