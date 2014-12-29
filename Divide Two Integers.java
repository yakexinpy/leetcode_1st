public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0) return 0;

        boolean isNeg = (dividend < 0) ^ (divisor < 0);
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        if(a < b) return 0;
        
        int ans = 0;
        while(a >= b){
            long c = b;
            int shift = 0;
            while(a >=c){
                ans += 1 << shift;
                shift++;
                a = a - c;
                c = c << 1;
            }
        }
        if(ans == Integer.MAX_VALUE || ans == Integer.MIN_VALUE)
        	return (isNeg) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        return (isNeg) ? -ans : ans;
    }
}
