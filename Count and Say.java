public class Solution {
    public String countAndSay(int n) {
        if(n <= 0)
            return "";
        
        if(n == 1)
            return "1";
            
        String result = "1";
        while(n > 1){
            String str = "";
            int index = 1;
            int count = 1;
            while(index <= result.length()){
                if(index < result.length() && result.charAt(index) == result.charAt(index - 1)){
                    index++;
                    count++;
                }
                else{
                    str = str + count + result.charAt(index - 1);
                    index++;
                    count = 1;
                }
            }
            result = str;
            n--;
        }
        return result;
    }
}
