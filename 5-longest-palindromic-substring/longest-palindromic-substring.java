class Solution {
    public String longestPalindrome(String s) {

        //Orbit Axis Theorem or DP
        String ans = "";
        // This is for oddlength
        for(int axis = 0 ; axis<s.length() ; axis++){
            int orbit = 1;
            int length = 1;
            while(axis+orbit < s.length() && axis-orbit>= 0){
                if(s.charAt(axis+orbit) == s.charAt(axis-orbit)){
                    orbit++;
                    length +=2;
                }
                else{
                    break;
                }
            }
            if(length>ans.length()){
                int startIndex = axis- length/2;
                 ans = s.substring(startIndex, startIndex+length);
            }
        }
        //For even length
        for(int axis = 0; axis<s.length()-1;axis++){
            int orbit = 1;
            int length = 0; //LENGTH IS ZERO BECAUSE WE HAVE KEPT THE AXIS IN BW THE THE CHARS A | B | C, here | is axis
            while(axis+orbit < s.length() && axis-orbit+1>= 0){
                if(s.charAt(axis+orbit) == s.charAt(axis-orbit+1)){
                    orbit++;
                    length +=2;
                }
                else{
                    break;
                }
        }
        if(length>ans.length()){
            int startIndex = axis-length/2 + 1;
              ans = s.substring(startIndex, startIndex+length);

        }
        
        
    }
    return ans;
}
}