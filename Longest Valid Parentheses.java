public class Solution {
    public int longestValidParentheses(String s) {
        int max = 0, cur = 0;
        if(s == null || s.length() < 2) return 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        int[] len = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(')
                stack.push(i);
            else{
                if(!stack.isEmpty()){
                    int index = stack.pop();
                    len[i] = (index > 0 ? len[index - 1] : 0) + (i > 0 ? len[i - 1] : 0) + 2;
                    max = Math.max(max, len[i]);
                }
            }
        }
        return max;
    }
}
