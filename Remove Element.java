public class Solution {
    public int removeElement(int[] A, int elem) {
        if(A.length == 0 || A == null)
            return 0;
        
        int count = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] != elem){
                A[count] = A[i];
                count++;
            }
        }
        return count;
    }
}
