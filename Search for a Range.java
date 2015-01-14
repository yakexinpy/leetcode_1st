public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] num = {-1, -1};
        if(A == null || A.length < 1) return num;
        
        int left = 0, right = A.length - 1;
        int mid = -1;
        while(left <= right){
            mid = (left + right) / 2;
            if(A[mid] == target) break;
            if(A[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        
        if(left > right) return num;
        
        left = mid;
        right = mid;
        while(left > 0 && A[left] == A[left - 1])
            left--;
        while(right < A.length - 1 && A[right] == A[right + 1])
            right++;
        
        num[0] = left;
        num[1] = right;
        return num;
    }
}
