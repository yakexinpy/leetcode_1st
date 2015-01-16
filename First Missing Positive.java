public class Solution {
    public int firstMissingPositive(int[] A) {
        if(A == null || A.length < 1) return 1;
        
        int i = 0;
        for(; i < A.length; i++){
            while(A[i] > 0 && A[i] <= A.length && A[A[i] - 1] != A[i]){
                    int temp = A[A[i] - 1];
                    A[A[i] - 1] = A[i];
                    A[i] = temp;
            }
        }
        
        for(i = 0; i < A.length; i++)
            if(A[i] != i + 1) 
                return (i + 1);
        
        return (A.length + 1);
    }
}
