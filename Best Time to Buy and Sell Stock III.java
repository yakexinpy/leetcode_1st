public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        int len = prices.length;
        int[] profits = new int[len + 1];
        profits[len] = 0;
        int max = 0;
        //find max profit in [i, len];
        for(int i = len - 1; i > -1; i--){
            max = Math.max(max, prices[i]);
            profits[i] = Math.max(profits[i + 1], max - prices[i]);
        }
        
        int min = max;
        int maxProf = 0;
        //find max profit in [0, i] and plux max profit in [i + 1, len]
        for(int i = 0; i < len; i++){
            min = Math.min(min, prices[i]);
            maxProf = Math.max(maxProf, prices[i] - min + profits[i + 1]);
        }
        return maxProf;
    }
}
