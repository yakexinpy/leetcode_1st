public class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 2) return s;
        String ret = "";
        char[] array = s.toCharArray();
        String str = "";
        
        for(int i = 0; i < array.length; i++){
            str = helper(s, i, i);
            ret = (ret.length() > str.length()) ? ret : str;
            
            str = helper(s, i, i + 1);
            ret = (ret.length() > str.length()) ? ret : str;
        }
        return ret;
    }
    
    private String helper(String s, int start, int end){
        char[] array = s.toCharArray();
        while(start > -1 && end < array.length && array[start] == array[end]){
            start--;
            end++;
        }
        return s.substring(start + 1, end);
    }
}
