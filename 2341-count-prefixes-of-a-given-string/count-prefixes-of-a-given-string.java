class Solution {
    public int countPrefixes(String[] words, String str) {
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        int left = 0;
        int right = 0;
       String prevString = "";

        for(int i =0;i<str.length(); i++){
           prevString = prevString+String.valueOf(str.charAt(i));
           map.put(prevString,0);
        }
        int ans = 0;

        for(int i = 0 ; i<words.length ; i++){
            if(map.containsKey(words[i])){
                ans++;
            }
        }
        return ans;
        
    }
}