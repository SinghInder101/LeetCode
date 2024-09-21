class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int length = 0;
        String ans = "";

        for(int i = 0 ; i<s.length() ; i++){
           if(ans.indexOf(s.charAt(i)) == -1){
            ans = ans+Character.toString(s.charAt(i));
            r++;
            System.out.println(ans);
            length = Math.max(length,ans.length());

           }else{
            ans = ans+Character.toString(s.charAt(i));
             l = ans.indexOf(s.charAt(i));
             l++;
             ans = ans.substring(l);
            System.out.println(ans);


           }
            
        }
return length;

        
    }
}