public class Solution {
    public List<String[]> solveNQueens(int n) {
        
        List<String[]> ret = new ArrayList<String[]>();
        if(n < 1) return ret;
            
        int[] cols = new int[n];
        helper(ret, 0, n, cols);
        return ret;
    }
    
    private void helper(List<String[]> ret, int n, int q, int[] cols){
        if(n == q){
            String[] temp = new String[q];
            for(int i = 0; i < q; i++){
                String str = "";
                for(int j = 0; j < q; j++){
                    if(cols[j] == i)
                        str += "Q";
                    else
                        str += ".";
                }
                temp[i] = str;
            }
            ret.add(temp);
        }
        else{
            for(int i = 0; i < q; i++){
                cols[n] = i;
                if(isValid(cols, n))
                    helper(ret, n + 1, q, cols);
            }
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
