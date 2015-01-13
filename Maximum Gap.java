public class Solution {
    public int maximumGap(int[] num) {
        /* Solution 1: sort
        if(num == null || num.length < 2) return 0;
        Arrays.sort(num);
        int cur = num[1] - num[0];
        int max = cur;
        for(int i = 1; i < num.length - 1; i++){
            cur = num[i + 1] - num[i];
            max = Math.max(cur, max);
        }
        return max;
        */
        
        /* Solution 2: bucket sort
        */
        if(num == null || num.length < 2) return 0;
        int max = num[0], min = num[0];
        for(int i = 1; i < num.length; i++){
            max = Math.max(max, num[i]);
            min = Math.min(min, num[i]);
        }
        
        boolean[] isFilled = new boolean[num.length + 1];
        int[] maxs = new int[num.length + 1];
        int[] mins = new int[num.length + 1];
        
        
        
        for(int i = 0; i < num.length; i++){
            int index = helper((num[i] - min),  num.length, (max - min));
            if(!isFilled[index]){
                isFilled[index] = true;
                maxs[index] = mins[index] = num[i];
            }
            else{
                maxs[index] = Math.max(maxs[index], num[i]);
                mins[index] = Math.min(mins[index], num[i]);
            }
        }
        
        int res = 0, last = -1;
        for(int i = 0; i <= num.length; i++){
            if(isFilled[i]){
                if(last < 0)
                    last = maxs[i];
                else{
                    res = Math.max(res, mins[i] - last);
                    last = maxs[i];
                }
            }
        }
        return res;
    }
    
    private int helper(int num, int n, int d){
        long x = num;
        long y = n;
        return (int)(x * y / d);
    }
}
