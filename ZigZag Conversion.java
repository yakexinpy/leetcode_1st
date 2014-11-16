public class Solution {
    public String convert(String s, int nRows) {
        if(s == null || nRows >= s.length() || nRows == 1)
            return s;
        
        int diff = 2*nRows - 2;
        String result = "";
        for(int i = 0; i < nRows; i++){
            for(int j = i; j < s.length(); j += diff){
                result += s.charAt(j);
                if(i > 0 && i < nRows - 1){
                    if(j + diff - i * 2 < s.length())
                        result += s.charAt(j + diff - i * 2);
                }
            }
        }
        return result;
    }
}
