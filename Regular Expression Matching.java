public class Solution {
    public boolean isMatch(String s, String p) {
        return helper(s, p, 0, 0);
    }
    
    private boolean helper(String s, String p, int i, int j){
        if(j == p.length())
            return i == s.length();
        
        if(j == p.length() - 1 || p.charAt(j + 1) != '*'){
            if(i < s.length() && s.charAt(i) == p.charAt(j) || (p.charAt(j) == '.' && i != s.length()))
                return helper(s, p, i + 1, j + 1);
            else
                return false;
        }
        
        while(i < s.length() && s.charAt(i) == p.charAt(j) || (p.charAt(j) == '.' && i != s.length())){
            if(helper(s, p, i, j + 2))
                return true;
            i++;
        }
        return helper(s, p, i, j + 2);
    }
}
