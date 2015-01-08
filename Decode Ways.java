public class Solution {
    public int numDecodings(String s) {
        int size = s.length();
        if(s == null || s.length() < 1) return 0;
        if(s.charAt(0) == '0') return 0;
        
        int prev = 1;
        int len2 = 1;
        int cur = 0;
        
        for(int i = 1; i <= size; i++){
            cur = 0;
            if(s.charAt(i - 1) != '0')
                cur = prev;
            if(i > 1){
                if(Integer.parseInt(s.substring(i - 2, i)) <= 26 && Integer.parseInt(s.substring(i - 2, i)) >= 10)
                    cur += len2;
                len2 = prev;
            }
            prev = cur;
        }
        return cur;
    }
}
