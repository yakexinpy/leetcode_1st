public class Solution {
    
    public int minCut(String s) {
        if(s == null || s.length() < 2) 
            return 0;
        int len = s.length();
        int[] cuts = new int[len + 1];
        for(int i = 0; i < len; ++i)
            cuts[i] = len - i;
        
        boolean[][] matrix = new boolean[len][len];
        char[] chs = s.toCharArray();
        
        for(int i = len - 1; i >= 0; --i){
            for(int j = i; j < len ; ++j){
                if(chs[i] == chs[j] && (j - i < 2 || matrix[i + 1][j - 1])){
                    matrix[i][j] = true;
                    cuts[i] = Math.min(cuts[i], cuts[j + 1] + 1);
                }
            }
        }
        return cuts[0] - 1;
    }
    
}
