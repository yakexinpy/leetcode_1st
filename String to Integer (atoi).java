public class Solution {
    public int atoi(String str) {
        if(str == null)
            return 0;
        if(str.trim().length() == 0)
            return 0;
        str = str.trim();
        boolean isNeg = false;
        int index = 0;
        if(str.charAt(0) == '-' || str.charAt(0) == '+')
            index += 1;
        if(str.charAt(0) == '-')
            isNeg = true;
            
        int res = 0;
        while(index < str.length()){
            if(str.charAt(index) > '9' || str.charAt(index) < '0')
                break;
            int digit = (int)(str.charAt(index) - '0');
            if(isNeg && res > -((Integer.MIN_VALUE + digit)/10))
                return Integer.MIN_VALUE;
            if(!isNeg && res > (Integer.MAX_VALUE - digit)/10)
                return Integer.MAX_VALUE;
            res = res*10 + digit;
            index++;
        }
        if(isNeg)
            return (0 - res);
        return res;
    }
}
