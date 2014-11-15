public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int index = m + n - 1;
        int a = m - 1;
        int b = n - 1;
        
        while(a >= 0 && b >= 0){
            if(A[a] > B[b]){
                A[index] = A[a];
                index--;
                a--;
            }
            else{
                A[index] = B[b];
                index--;
                b--;
            }
        }
        while(a >= 0){
            A[index] = A[a];
            index--;
            a--;
        }
        while(b >= 0){
            A[index] = B[b];
            index--;
            b--;
        }
    }
}
