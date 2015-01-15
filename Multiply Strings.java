public class Solution {
    public String multiply(String num1, String num2) {
        if(num1 == null || num1.length() < 1 || num1.equals("0")) return "0";
        if(num2 == null || num2.length() < 1 || num2.equals("0")) return "0";
        
        int[] x = new int[num1.length()];
        int[] y = new int[num2.length()];
        int[] res = new int[num1.length() + num2.length()];
        
        for(int i = 0; i < x.length; i++)
            x[i] = (num1.charAt(i) - '0');
        for(int i = 0; i < y.length; i++)
            y[i] = (num2.charAt(i) - '0');
        //for(int i = 0; i < res.length; i++)
        //    res[i] = -1;
            
        for(int i = x.length - 1; i >= 0; i--){
            int carry = 0, j = y.length - 1;
            for(; j >= 0; j--){
                //if(res[i + j + 1] < 0) res[i + j + 1] = 0;
                res[i + j + 1] += x[i] * y[j] + carry;
                carry = res[i + j + 1] / 10;
                res[i + j + 1] = res[i + j + 1] % 10;
            }
            if(i + j + 1 >= 0){
            	//if(res[i + j + 1] < 0) res[i + j + 1] = 0;
            	res[i + j + 1] += carry;
            }
        }
        
        
        String ret = "";
        for(int i = 0; i < res.length && res[i] >= 0; i++){
        	if(ret.length() < 1 && res[i] == 0) continue;
            ret += "" + res[i];
        }
        
        return ret;
    }
}
