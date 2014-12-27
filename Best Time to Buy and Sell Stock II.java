public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        
        int profit = 0;
        int df = 0;
        for(int i = 1; i < prices.length; i++){
            df = prices[i] - prices[i - 1];
            if(df > 0)
                profit += df;
        }
        
        return profit;
    }
}
