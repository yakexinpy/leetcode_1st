public class Solution {
    public int maxArea(int[] height) {
        if(height == null || height.length < 1) return 0;
        if(height.length < 2) return height[0];
        
        int left = 0;
        int right = height.length - 1;
        int max = Integer.MIN_VALUE;
        
        while(left < right){
            int tmp = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, tmp);
            if(height[left] < height[right])
                left++;
            else
                right--;
        }
        
        return max;
    }
}
