public class Solution {
    public int totalNQueens(int n) {
        if(n < 1) return 0;
        int total = 0;
        int[] cols = new int[n];
        total = helper(total, cols, 0, n);
        return total;
    }
    
    private int helper(int total, int[] cols, int n, int q){
        if(n == q){
            total += 1;
            return total;
        }
        else{
            for(int i = 0; i < q; i++){
                cols[n] = i;
                if(isValid(cols, n))
                    total = helper(total, cols, n + 1, q);
            }
            return total;
        }
    }
    
    private boolean isValid(int[] cols, int n){
        for(int i = 0; i < n; i++){
            if(cols[i] == cols[n]) return false;
            if(Math.abs(cols[i] - cols[n]) == n - i) return false;
        }
        return true;
    }
}
