public class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0 )
            return 0;
        String[] split = s.split(" ");
        if(split.length < 1)
            return 0;
        int len = split.length;
        return split[len - 1].length();
    }
}
