public class Solution {
    public int removeDuplicates(int[] A) {
        if(A == null || A.length < 1)  return 0;
        
        int len = A.length;
        int a = 1, count = 1, i = 1;
        for(; i < A.length; i++){
            if(A[i] == A[i - 1]){
                if(count < 2){
                    count++;
                    A[a] = A[i];
                    a = a + 1;
                }
                else{
                    count++;
                    len--;
                }
            }
            else{
                A[a] = A[i];
                count = 1;
                a = a + 1;
            }
        }
        
        return len;
    }
}
