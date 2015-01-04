public class Solution {
    public String getPermutation(int n, int k) {
        //if(n == 0 || k < 1) return ""; 
        int fac = 1;
        for(int i = 2; i < n; i++)
            fac *= i;
            
        List<Integer> nums = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++)
            nums.add(i);
        
        int rest = n - 1;
        String ret = "";
        k--;
        while(rest >= 0){
            int cur = k / fac;
            ret += nums.get(cur);
            nums.remove(cur);
            k = k % fac;
            if(rest != 0) fac = fac/rest;
            rest--;
        }
        return ret;
    }
}
