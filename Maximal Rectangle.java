public class Solution {
    public int largestRectangleArea(int[] height) {
        int maxArea = 0;
        if(height == null || height.length < 1) return maxArea;
        
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < height.length; i++){
            if(stack.isEmpty()){
                stack.push(i);
                continue;
            }
            while(!stack.isEmpty() && height[stack.peek()] > height[i]){
                int h = height[stack.peek()];
                stack.pop();
                maxArea = Math.max(maxArea, (i - 1 - (stack.isEmpty() ? (-1) : stack.peek())) * h);
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            int h = height[stack.peek()];
            stack.pop();
            maxArea = Math.max(maxArea, (height.length - 1 - (stack.isEmpty() ? (-1) : stack.peek())) * h);
        }

        return maxArea;
    }
}
