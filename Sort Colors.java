public class Solution {
    public void sortColors(int[] A) {
        if(A == null)
            return;
        int i,j,k;
        i = 0;
        j = 0;
        k = A.length - 1;
        
        for(i = 0; i <= k; i++){
            if(A[i] == 0){
                A[i] = A[j];
                A[j++] = 0;
            }
            else if(A[i] == 2){
                A[i--] = A[k];
                A[k--] = 2;
            }
        }
    }
}
