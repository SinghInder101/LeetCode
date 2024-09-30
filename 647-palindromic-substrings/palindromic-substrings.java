class Solution {
    public int countSubstrings(String s) {
        //Orbit Axis Theorem
        int count = 0;
        for(int axis = 0 ; axis<s.length() ; axis++){
            int orbit = 1;
            int length = 1;
            count++;
            while(axis-orbit >= 0 && axis+orbit<s.length()){
                if(s.charAt(axis-orbit) == s.charAt(axis+orbit)){
                    count++;
                    orbit++;
                    continue;
                }
                else{
                    
                    
                    break;
                }
                

            }
        }
        for(int axis = 0; axis<s.length() - 1 ; axis++){
            int orbit = 1;
            int length = 0;
          
            while(axis-orbit+1>=0 && axis+orbit<s.length()){
                 if(s.charAt(axis-orbit+1) == s.charAt(axis+orbit)){
                    count++;
                    orbit++;
                    continue;
                }
                else{
                    break;
                    
                }
            }
        }
        return count;
        
    }
}