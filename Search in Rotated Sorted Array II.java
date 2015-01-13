public class Solution {
    public boolean search(int[] A, int target) {
        if(A == null || A.length < 1) return false;
        
        int left = 0, right = A.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(A[mid] == target) return true;
            if(A[mid] > A[left]){
                if(A[left] <= target && A[mid] >target)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            else if(A[mid] < A[left]){
                if(A[right] >= target && A[mid] < target)
                    left = mid + 1;
                else 
                    right = mid - 1;
            }
            else
                left ++;
        }
        return false;
    }
}
