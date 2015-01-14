public class Solution {
    public int findMin(int[] num) {
        if(num == null || num.length < 1) return Integer.MAX_VALUE;
        
        int left = 0, right = num.length - 1;
        int mid = -1;
        while(left < right - 1){
            while(left < right - 1 && num[left] == num[left + 1])
                left++;
            while(right - 1> left && num[right] == num[right - 1])
                right--;
            
            mid = (left + right) / 2;
            if(num[right] > num[mid])
                right = mid;
            else
                left = mid;
        }
        
        return (num[left] > num[right]) ? num[right] : num[left];
    }
}
