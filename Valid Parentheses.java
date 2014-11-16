public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')  
                stack.push(s.charAt(i));
            else if(s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}'){
                if(stack.isEmpty())
                    return false;
                char ch = stack.pop();
                if(ch == '(' && s.charAt(i) != ')' )
                    return false;
                if(ch == '[' && s.charAt(i)  != ']')
                    return false;
                if(ch == '{' && s.charAt(i) != '}')
                    return false;
            }
        }
        if(stack.isEmpty())
            return true;
        return false;
    }
}
