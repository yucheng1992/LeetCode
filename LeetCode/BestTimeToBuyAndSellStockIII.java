public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] profitUntil = new int[prices.length];
        int[] profitFrom = new int[prices.length];
        profitUntil[0] = 0;
        int minValue = prices[0];
        for (int i=1; i<prices.length; i++) {
            minValue = prices[i] < minValue ? prices[i] : minValue;
            profitUntil[i] = Math.max(profitUntil[i-1], prices[i] - minValue);
        }
        profitFrom[prices.length-1] = 0;
        int maxValue = prices[prices.length-1];
        for (int i=prices.length-2; i>=0; i--) {
            maxValue = prices[i] > maxValue ? prices[i] : maxValue;
            profitFrom[i] = Math.max(profitFrom[i+1], maxValue - prices[i]);
        }
        int maxProfit = 0;
        for (int i=0; i<prices.length; i++) {
            maxProfit = Math.max(maxProfit, profitUntil[i] + profitFrom[i]);
        }
        return maxProfit;
    }
}
