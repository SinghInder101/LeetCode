class Solution {
    public boolean isPalindrome(String s) {
        String str = "";

        for(int i = 0 ; i<s.length() ; i++){
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                if(Character.isLetter(ch)){
                ch = Character.toLowerCase(ch);
                }
            
                
                 str = str + Character.toString(ch);
            }

        }
        int left = 0;
        int right = str.length()-1;
        System.out.println(str);
        while(right>left){
            if(str.charAt(right) != str.charAt(left)){
                return false;
            }
            right--;
            left++;

        }
        return true;


        
    }
}