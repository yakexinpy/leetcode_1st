public class Solution {
    public int compareVersion(String version1, String version2) {
        char[] v1 = version1.toCharArray();
        char[] v2 = version2.toCharArray();

        for(int i1 = 0, i2 = 0; i1 < v1.length || i2 < v2.length; i1++, i2++){
            int num1 = 0;

            while(i1 < v1.length && v1[i1] != '.'){
                char ch = v1[i1];
                num1 = num1 * 10 + (ch - '0');
                i1++;
            }
            
            int num2 = 0;
            while(i2 < v2.length  && v2[i2] != '.'){
                char ch = v2[i2];
                num2 = num2 * 10 + (ch - '0');
                i2++;
            }
            
            if(num1 > num2) return 1;
            if(num1 < num2) return -1;
        }
        
        
        return 0;
    }
}
