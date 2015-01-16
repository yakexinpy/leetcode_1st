public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(denominator == 0) return "";
        if(numerator == 0) return "0";
        
        //deal with negtive number
        boolean isNeg = numerator < 0;
        numerator = Math.abs(numerator);
        isNeg = isNeg ^ (denominator < 0);
        denominator = Math.abs(denominator);
        
        long m = numerator;
        long n = denominator;
        if(numerator == Integer.MIN_VALUE){
            m = Integer.MAX_VALUE;
            m++;
        }
        
        if(denominator == Integer.MIN_VALUE){
            n = Integer.MAX_VALUE;
            n++;
        }
        String ret = "";
        ret += "" + (m / n);
        long rem = m % n;
        if(rem == 0) return (isNeg) ? "-" + ret : ret;
        ret += ".";
        
        String floats = "";
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        long res = 0;
        rem = rem * 10;
        while(rem != 0){
            if(map.containsKey(rem)){
                int index = map.get(rem);
                String rec = floats.substring(index, floats.length());
                floats = floats.substring(0, index);
                ret += floats + "(" + rec + ")";
                return (isNeg) ? "-" + ret : ret;
            }
            
            map.put(rem, floats.length());
            res = rem / n;
            floats += "" + res;
            rem = (rem % n) * 10;
        }
        
        ret += floats;
        return (isNeg) ? "-" + ret : ret;
    }
}
