public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length < 1)
            return "";
        if(strs.length == 1)
            return strs[0];
        
        int min = minLen(strs);
        int index = 0;
        String prefix = "";
        while(index < min){
            for(int i = 1; i < strs.length; i++){
                if(strs[i].charAt(index) != strs[i-1].charAt(index))
                    return prefix;
            }
            prefix += strs[0].charAt(index);
            index++;
        }
        return prefix;
    }
    
    private int minLen(String[] strs){
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < strs.length; i++){
            if(strs[i].length() < min)
                min = strs[i].length();
        }
        return min;
    }
}
