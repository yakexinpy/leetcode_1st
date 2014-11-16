public class Solution {
    public boolean isPalindrome(String s) {
        if(s == "" || s.length() == 0)
            return true;
            
        int l = 0; 
        int r = s.length() - 1;
        s = s.toLowerCase();
        while(l < r){
            if(!isValid(s.charAt(l))){
                l++;
                continue;
            }
            if(!isValid(s.charAt(r))){
                r--;
                continue;
            }
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }
            else
                return false;
        }
        return true;
    }
    
     private boolean isValid(char ch){
        if(ch >= 'a' && ch <= 'z' || ch >='0' && ch <= '9')
            return true;
        return false;
    }
}
