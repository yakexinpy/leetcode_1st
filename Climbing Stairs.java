public class Solution {
    public int climbStairs(int n) {
        if(n <= 0)
            return 0;
        if(n < 3)
            return n;
        int sum = 0;
        int n1 = 1, n2 = 2;
        for(int i = 3; i <= n; i++){
            sum = n1 + n2;
            n1 = n2;
            n2 = sum;
        }
        return sum;
    }
}
