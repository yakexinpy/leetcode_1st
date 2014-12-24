public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if(s == null || s.length() == 0) return true;
        boolean[] flag = new boolean[s.length() + 1];
        flag[0] = true;
        
        for(int i = 0; i < s.length(); i++){
            if(!flag[i]) continue;
            
            for(String str : dict){
                int len = str.length();
                if(i + len > s.length()) continue;
                if(flag[len + i]) continue;
                if(str.equals(s.substring(i, i + len)))
                    flag[i + len] = true;
            }
        }
        
        return flag[s.length()];
    }
}
