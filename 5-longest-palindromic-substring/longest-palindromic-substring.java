class Solution {
    public String longestPalindrome(String s) {
        int arr[] = new int [5];
        

        //Orbit Axis Theorem or DP
        String ans = "";
        // This is for oddlength
        for(int axis = 0 ; axis<s.length() ; axis++){
            int orbit = 1;
            int length = 1;
            while(axis+orbit < s.length() && axis-orbit>= 0){
                if(s.charAt(axis+orbit) == s.charAt(axis-orbit)){
                    orbit++;
                    length += 2;
                }
                else{
                    break;
                }
            }
            if(length>ans.length()){
                int startIndex = axis - length/2;
                 ans = s.substring(startIndex, startIndex+length);
            }
        }
        //For even length
        for(int axis = 0; axis<s.length()-1;axis++){
            int orbit = 1;
            int length = 0; //LENGTH is zero becaue the minimum length of even palindrome could be two
            while(axis+orbit < s.length() && axis-orbit+1>= 0 // (+1 is added to make sure it checks the current value it is on as well)
            ){
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