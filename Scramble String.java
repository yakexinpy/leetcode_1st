public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        if(s1.length() == 1 && s2.length() == 1) return s1.equals(s2);
        if(s1.equals(s2)) return true;
        
        char[] t1 = s1.toCharArray(), t2 = s2.toCharArray();
        Arrays.sort(t1);
        Arrays.sort(t2);
        if(! new String(t1).equals(new String(t2))) return false;
        
        for(int i = 1; i < s1.length(); i++){
            boolean result = isScramble(s1.substring(0, i), s2.substring(0,i)) && isScramble(s1.substring(i, s1.length()), s2.substring(i, s1.length()));
            result = result || (isScramble(s1.substring(0, i), s2.substring(s1.length() - i)) && isScramble(s1.substring(i, s1.length()), s2.substring(0, s1.length() - i)));
            if(result) return true;
        }
        return false;
    }
}
