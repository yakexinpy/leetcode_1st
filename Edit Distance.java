public class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();
        if(n1 == 0 || n2 == 0)
            return Math.max(n1, n2);
        
        int[][] matrix = new int[n1 + 1][n2 + 1];
        for(int i = 0; i <= n1; i++)
            matrix[i][0] = i;
        for(int i = 0; i <= n2; i++)
            matrix[0][i] = i;
            
        for(int i = 1; i <= n1; i++){
            for(int j = 1; j <= n2; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1))
                    matrix[i][j] = matrix[i - 1][j - 1];
                else
                    matrix[i][j] = Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i][j - 1])) + 1;
            }
        }
        return matrix[n1][n2];
    }
}
