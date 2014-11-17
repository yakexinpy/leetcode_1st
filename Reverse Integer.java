public class Solution {
    public int reverse(int x) {
        if(x < 9 && x > -9)
            return x;
        
        boolean isNeg = false;
        if(x < 0){
            isNeg = true;
            x = 0 - x;
        }
        int res = 0;
        while(x > 0){
            int digit = x % 10;
            if(isNeg && res > -((Integer.MIN_VALUE + digit)/10))
                return 0;
            if(!isNeg && res > (Integer.MAX_VALUE - digit)/10)
                return 0;
            res = res * 10 + digit;
            x = x / 10;
        }
        if(isNeg)
            return (0 - res);
        return res;
    }
}
