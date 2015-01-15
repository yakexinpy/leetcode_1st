public class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() < 1) return s;
        
        s = s.trim();
        String[] strs = s.split(" ");
        String ret = "";
        for(String str : strs){
            str = str.trim();
            if(str.length() < 1) continue;
            ret = str + " " + ret;
        }
        
        return ret.trim();
    }
}
