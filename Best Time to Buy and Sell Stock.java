public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){  
            return 0;  
        }  
        
        int len = prices.length;
        int max = 0;
        int profit = 0;
        for(int i = len - 1; i > -1; i--){
            max = Math.max(max, prices[i]);
            profit = Math.max(profit, max - prices[i]);
        }
        
        return profit;
    }
}
