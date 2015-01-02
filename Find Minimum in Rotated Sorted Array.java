public class Solution {
    public int findMin(int[] num) {
        if(num == null || num.length < 1) return -1;
        
        int left = 0;
        int right = num.length - 1;
        int mid;
        
        while(right - left > 1){
            mid = (left + right) / 2;
            if(num[mid] > num[right])
                left = mid;
            else
                right = mid;
        }
        return (num[left] < num[right]) ? num[left] : num[right];
    }
}
