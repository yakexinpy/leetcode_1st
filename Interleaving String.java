public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null)
            return false;
            
        if(s1.length() + s2.length() != s3.length())
            return false;
        
        boolean[][] matrix = new boolean[s1.length() + 1][s2.length() + 1];
        matrix[0][0] = true;
        
        for(int i = 1; i <= s1.length(); i++)
            matrix[i][0] = (s1.charAt(i - 1) == s3.charAt(i - 1) && matrix[i - 1][0]);
        for(int i = 1; i <= s2.length(); i++)
            matrix[0][i] = (s2.charAt(i - 1) == s3.charAt(i - 1) && matrix[0][i - 1]);
            
        for(int i = 1; i <= s1.length(); i++){
            for(int j = 1; j<= s2.length(); j++){
                if(s1.charAt(i - 1) == s3.charAt(i + j - 1) && matrix[i - 1][j])
                    matrix[i][j] = true;
                if(s2.charAt(j - 1) == s3.charAt(i + j - 1) && matrix[i][j - 1])
                    matrix[i][j] = true;
            }
        }
        return matrix[s1.length()][s2.length()];
    }
}
