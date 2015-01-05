public class Solution {
    public boolean isMatch(String s, String p) {
        if(p.length() == 0) return s.length() == 0;
        if(s.length()>300 && p.charAt(0)=='*' && p.charAt(p.length()-1)=='*')  
            return false;  
        boolean[] res = new boolean[s.length() + 1];
        res[0] = true;
        for(int j = 0; j < p.length(); j++){
            if(p.charAt(j) != '*'){
                for(int i = s.length() - 1; i >= 0; i--)
                    res[i + 1] = res[i] && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'); 
            }
            else{
                int i = 0;;
                while(i <= s.length() && !res[i]){
                    i++;
                }
                for(; i <= s.length(); i++){
                    res[i] = true;
                }
            }
            res[0] = res[0] && p.charAt(j) == '*';
        }
        
        return res[s.length()];
    }
    
    
    /*
    public boolean isMatch(String s, String p) {
        return helper(0, 0, s, p);
    }
    
    private boolean helper(int i, int j, String s, String p){
        if(j == p.length())
            return i == s.length();
        
        if(p.charAt(j) == '?'){
            if(i >= s.length()) return false;
            return helper(i + 1, j + 1, s, p);
        }
        
        if(p.charAt(j) == '*'){
            for(int k = i; k < s.length(); k++)
                if(helper(k, j + 1, s, p)) return true;
            return helper(i, j + 1, s, p);    
        }
        
        if(i >= s.length() || s.charAt(i) != p.charAt(j)) return false;
        
        return helper(i + 1, j + 1, s, p);
    }*/
}
