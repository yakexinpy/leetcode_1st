public class Solution {
    public int sqrt(int x) {
        int left = 0, right = x / 2 + 1;
        
        while(left < right){
            long mid = (left + right + 1) / 2;
            long sqr = mid *  mid;
            if(sqr == (long)x) return (int)mid;
            if(sqr <= (long)x)
                left = (int)mid;
            else
                right = (int)mid - 1;
        }
        return (left + right + 1) / 2;
    }
}
