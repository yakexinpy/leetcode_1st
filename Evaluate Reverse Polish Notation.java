public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length < 1)
            return 0;
        //if(Character.isDigit(token[0].charAt(0)))
        //    return -1;
            
        Stack<Integer> stack = new Stack<Integer>();
        int sum = 0;
        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") ||tokens[i].equals("/")){
                int b = (stack.isEmpty())? 0 : stack.pop();
                int a = (stack.isEmpty())? 0 : stack.pop();
                if(tokens[i].equals("+"))
                    stack.push(a + b);
                else if(tokens[i].equals("-"))
                    stack.push(a - b);
                else if(tokens[i].equals("*"))
                    stack.push(a * b);
                else if(tokens[i].equals("/")){
                    if(b == 0)
                        stack.push(0);
                    else
                        stack.push(a / b);
                }
            }
            else
                stack.push(Integer.parseInt(tokens[i]));
        }
        return stack.pop();
    }
}
