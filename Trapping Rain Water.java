public class Solution {
    public int trap(int[] A) {
        int[] leftHigh = new int[A.length];
        int[] rightHigh = new int[A.length];
        
        int high = 0;
        for(int i = 0; i < A.length; i++){
            if(high < A[i]) high = A[i];
            leftHigh[i] = high;
        }
        high = 0;
        for(int i = A.length - 1; i > -1; i--){
            if(high < A[i]) high = A[i];
            rightHigh[i] = high;
        }
        
        int total = 0;
        for(int i = 0; i < A.length; i++){
            total += Math.min(leftHigh[i], rightHigh[i]) - A[i];
        }
        return total;
    }
}
