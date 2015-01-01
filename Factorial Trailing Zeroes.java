public class Solution {
    public int trailingZeroes(int n) {
        int r = 0;
        for( ;n > 0 ; r += (n /= 5))
            ;
        return r;
    }
}
