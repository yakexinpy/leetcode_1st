public class Solution {
    public int titleToNumber(String s) {
        if(s == null || s.length() < 1) return 0;
        
        int sum = 0;
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            sum = sum * 26 + (ch - 'A' + 1);
        }
        
        return sum;
    }
}
