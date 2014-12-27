public class Solution {
    public int maxSubArray(int[] A) {
        if(A.length == 0) return 0;
        int sum = 0;
        int max = A[0];
        
        for(int i = 0; i < A.length; i++){
            sum += A[i];
            if(sum > max)
                max = sum;
            if(sum < 0)
                sum = 0;
        }
        return max;
    }
}
