public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits== null || digits.length == 0)
            return digits;
        
        int len = digits.length;
        int count;
        digits[len - 1] += 1;
        if(digits[len - 1] > 9){
            count = 1;
            digits[len - 1] = digits[len - 1] % 10;
        }
        else
            return digits;
        
        for(int i = len - 2; i >= 0; i--){
            if(digits[i] + count> 9){
                digits[i] = (digits[i] + count) % 10;
                count = 1;
            }
            else{
                digits[i] = digits[i] + count;
                count = 0;
            }
        }
        
        if(count == 1){
            int[] res = new int[len + 1];
            res[0] = 1;
            for(int i = 1; i <= len; i++)   
                res[i] = digits[i-1];
            return res;
        }       
        
        return digits;
    }
}
