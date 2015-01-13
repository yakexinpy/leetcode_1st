public class Solution {
    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        Stack<String> stack = new Stack<String>();
        
        for(int i = 0; i < strs.length; i++){
            String str = strs[i];
            if(str.equals("."))
                continue;
            else if(str.equals("..")){
                if(!stack.isEmpty())
                    stack.pop();
            }
            else{
                if(str.length() > 0)
                    stack.push(str);
            }
        }
        
        String ret = "/";
        while(!stack.isEmpty()){
            ret = '/' + stack.pop() + ret;
        }
        if(ret.length() > 1 && ret.charAt(ret.length() - 1) == '/')
            ret = ret.substring(0, ret.length() - 1);
        
        return ret;
    }
}
