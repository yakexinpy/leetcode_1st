public class Solution {
    public int searchInsert(int[] A, int target) {
        if(A == null || A.length < 1) return -1;
        
        int l = 0, r = A.length - 1;
        while(l <= r){
            int m = l + (r - l) / 2;
            if(A[m] == target) return m;
            if(m > l && A[m] > target && A[m - 1] < target) return m;
            if(A[m] > target) r = m - 1;
            else l = m + 1;
        }
        return l;
    }
}
