class Solution {
    public char repeatedCharacter(String s) {
        HashMap<Character,Integer> map = new HashMap<Character,Integer> ();
        for(int i = 0 ; i < s.length() ; i ++ ){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),i);
            }
            else{
                return s.charAt(i);
            }
        }
        return 'a';
        
    }
}