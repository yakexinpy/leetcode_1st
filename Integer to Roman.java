public class Solution {
    public String intToRoman(int num) {
        if(num == 0) return "";
        String[] roman = new String[4];
        int i = 3;
        while(num != 0){
            int tmp = num % 10;
            num = num / 10;
            roman[i] = genRoman(i, tmp);
            i--;
        }
        String ret = "";
        for(int j = 0; j < roman.length; j++){
            ret += (roman[j] != null) ? roman[j] : "";
        }
        return ret;
    }
    
    private String genRoman(int digit, int value){
        String res = "";
        if(value == 0) return res;
        char[] roman = {'M','D','C','L','X','V','I'};
        
            if(value > 0 && value < 4){
                while(value > 0){
                    res += roman[2 * digit];
                    value --;
                }
            }
            else if(value == 4)
                res += roman[2 * digit] + "" + roman[2 * digit - 1];
            else if(value > 4 && value < 9){
                res += roman[2 * digit - 1];
                value = value % 5;
                while(value > 0){
                    res += roman[2 * digit];
                    value --;
                }
            }
            else if(value == 9)
                res += roman[2 * digit] + "" + roman[2 * digit - 2];
        
        
        return res;
    }
}
