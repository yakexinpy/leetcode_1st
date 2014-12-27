public class Solution {
    public int maxProduct(int[] A) {
        if(A.length == 0) return 0;
        if(A.length == 1) return A[0];
        
        int max = A[0];
        int min = A[0];
        int product = A[0];
        
        for(int i = 1; i < A.length; i++){
            int tmpMax = A[i] * max;
            int tmpMin = A[i] * min;
            max = Math.max(Math.max(tmpMax, tmpMin), A[i]);
            min = Math.min(Math.min(tmpMax, tmpMin), A[i]);
            product = Math.max(product, max);
        }
        return product;
    }
}
