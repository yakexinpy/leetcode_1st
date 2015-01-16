public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        if(n < 1) return ret;
        
        int sqr = n * n;
        
        int k= 0;
        int count = 1;
        
        while(k < n / 2){
            int i = k, j = k;
            while(j < n - k - 1)
                ret[i][j++] = count++;
            while(i < n - k - 1)
                ret[i++][j] = count++;
            while(j > k)
                ret[i][j--] = count++;
            while(i > k)
                ret[i--][j] = count++;
            k++;
        }
        
        if(n % 2 == 1)
            ret[n / 2][n / 2] = sqr;
        return ret;
    }
}
