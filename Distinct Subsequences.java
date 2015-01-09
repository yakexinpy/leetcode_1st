public class Solution {
    public int numDistinct(String S, String T) {
        if(S == null || T== null || S.length() < T.length()) return 0;
        int[][] matrix = new int[S.length() + 1][T.length() + 1];
        matrix[0][0] = 1;
        
        for(int i = 1; i <= S.length(); i++)
            matrix[i][0] = 1;
            
        for(int i = 1; i <= S.length(); i++){
            for(int j = 1; j <= T.length(); j++){
                if(S.charAt(i - 1) == T.charAt(j - 1))
                    matrix[i][j] = matrix[i - 1][j] + matrix[i - 1][j - 1];
                else
                    matrix[i][j] = matrix[i - 1][j];
            }
        }
        return matrix[S.length()][T.length()];
    }
}
