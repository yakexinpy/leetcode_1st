public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix[0].length;
        int limit = (n - 1) / 2;
        
        for(int i = 0; i <= limit; i++){
            for(int j = i; j < n - 1 - i; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = tmp;
            }
        }
    }
}