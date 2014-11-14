public class Solution {
    public int threeSumClosest(int[] num, int target) {
        if(num.length < 3 && num == null)
            return Integer.MAX_VALUE;
        
        Arrays.sort(num);
        int min = num[0] + num[1] + num[2] - target;
        for(int i = num.length - 1; i > 1; i--){
            int tmp = twoSum(num, i-1, target - num[i]);
            if(Math.abs(tmp) < Math.abs(min))
                min = tmp;
        }
        return min + target;
    }
    
    public int twoSum(int[] num, int end, int target){
        if(num.length < 1 && num == null)
            return Integer.MAX_VALUE;
        
        int diff = num[end] + num[end - 1] -target;
        int l = 0; 
        int r = end;
        while(l < r){
            if(num[l] + num[r] == target)
                return 0;
            int d = num[l] + num[r] - target;
            if(Math.abs(d) < Math.abs(diff))
                diff = d;
            if(d > 0)
                r--;
            else
                l++;
        }
        return diff;
    }
}