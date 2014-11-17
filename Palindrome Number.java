public class Solution {
    public boolean isPalindrome(int x) {
        int len = String.valueOf(x).length();
        if(x < 0)
            return false;
        if(x < 10)
            return true;
        int div = helper(len);
        while(x != 0){
            int left = x / div;
            int right = x % 10;
            
            if(left != right)
                return false;
            
            x = (x % div) / 10;
            div = div / 100;
        }
        return true;
    }
    
    private int helper(int n){
        if(n == 1)
            return 10;
        int num = 1;
        for(int i = 1; i < n; i++)
            num *= 10;
        return num;
    }
}
