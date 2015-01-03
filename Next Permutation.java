public class Solution {
    public void nextPermutation(int[] num) {
        if(num.length < 2) return;
        int i = num.length - 1;
        while(i > 0 && num[i] <= num[i - 1]) i--;
        
        int j = (i > 0) ? num.length - 1 : 0;
        if(i > 0){
            i--;
            while(j > 0 && num[j] <= num[i]) j--;
            int tmp = num[i];
            num[i] = num[j];
            num[j] = tmp;
            j = i + 1;
        }
        
        int k = num.length - 1;
        while(j < k){
            int tmp = num[j];
            num[j] = num[k];
            num[k] = tmp;
            k--;
            j++;
        }
        
    }
}
