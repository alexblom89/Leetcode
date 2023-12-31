package Array.String;
/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */

public class BuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for(int i=1;i<prices.length;i++){
            maxProfit = Math.max(maxProfit,prices[i]-minPrice);
            minPrice = Math.min(prices[i],minPrice);
        }

        return maxProfit;
    }
}
