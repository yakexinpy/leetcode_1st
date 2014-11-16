public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length())
            return -1;
        if(needle.length() == 0 || haystack.equals(needle))
            return 0;
        int[] matchTable = getTable(needle);
        int index = 0;
        int start = 0;
        boolean flag = false;
        int i;
        for(i = 0; i < haystack.length(); i++){
            while(index > 0 && haystack.charAt(i) != needle.charAt(index)){
                index = matchTable[index - 1];
                flag = false;
            }
            if(haystack.charAt(i) == needle.charAt(index)){
                if(!flag)
                    start = i - index;
                flag = true;
                index++;
            }
            if(index == needle.length())//found
                return start;
        }
        return -1;
    }
    
    private int[] getTable(String s){
        int[] table = new int[s.length()];
        int val = 0;
        table[0] = 0;
        for(int i = 1; i < s.length(); i++){
            while(val > 0 && s.charAt(i) != s.charAt(val))
                val = table[val - 1];
            if(s.charAt(i) == s.charAt(val))
                val++;
            table[i] = val;
        }
        return table;
    }
}
