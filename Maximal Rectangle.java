public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;
        
        int[] height = new int[matrix[0].length + 1];
        int max = 0;
        
        for(int i = 0; i < matrix.length; i++){
            Stack<Integer> stack = new Stack<Integer>();
            for(int j = 0; j < height.length; j++){
                height[j] = (j < height.length - 1 && matrix[i][j] == '1') ? height[j] + 1 : 0;
                if(stack.isEmpty() || height[j] >= height[stack.peek()]){
                    stack.push(j);
                    continue;
                }
                while(!stack.isEmpty() && height[j] < height[stack.peek()]){
                    int h = height[stack.peek()];
                    stack.pop();
                    max = Math.max(max, h * (j - 1 - (stack.isEmpty() ? (-1) : stack.peek())));
                }
                stack.push(j);
            }
        }
        return max;
    }
}
