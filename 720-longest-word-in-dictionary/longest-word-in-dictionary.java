class Solution {
    public String longestWord(String[] words) {

         HashMap<String, Boolean> map = new HashMap<>();

        // Sort the words array
        Arrays.sort(words);

        // Iterate over each word in the sorted array
        for (String str : words) {
            // Mark true if length is 1, otherwise false
            map.put(str, str.length() == 1);
        }
        String ans= "";

        for(String s: words){

            if(s.length() >1 ){
               if(map.containsKey(s.substring(0,s.length()-1)) && map.get(s.substring(0,s.length()-1)) ==true ) {
                map.put(s.substring(0,s.length()-1), true);
                map.put(s.substring(0,s.length()), true);
                if(s.substring(0,s.length()).length() > ans.length()){
                    ans = s.substring(0,s.length());
                }
               }
                

            }
            else if(s.length() == 1){
                 map.put(s.substring(0,s.length()), true);
                  if(s.substring(0,s.length()).length() > ans.length()){
                    ans = s.substring(0,s.length());
                }

            }
            System.out.println(ans);
        }
        return ans;



        
    }
}