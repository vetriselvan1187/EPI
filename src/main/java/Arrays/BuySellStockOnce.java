package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vetriselvan on 31-12-2017.
 * 6.6 Buy And Sell Stock Once - get the maximum profit
 *  Time Complexity is o(n) Space Complexity is o(1)
 */
public class BuySellStockOnce {
    public static void main(String[] args) {
        int[] stockPrices = {310, 315, 275, 295, 260, 270, 290, 230, 255, 250 };
        BuySellStockOnce buySellStockOnce = new BuySellStockOnce();
        System.out.println(buySellStockOnce.getMaximumProfit(stockPrices));
        System.out.println(buySellStockOnce.getListOfProfits(stockPrices));
    }

    private int getMaximumProfit(int[] stockPrices) {
        int i=0, j=0, max = Integer.MIN_VALUE;
        while(j < stockPrices.length) {
            if(stockPrices[j] >= stockPrices[i]) {
                max = Math.max(max, stockPrices[j]-stockPrices[i]);
                j++;
            } else {
                i = j;
            }
        }
        return max;
    }

    private List<Integer> getListOfProfits(int[] stockPrices) {
        List<Integer> profits = new ArrayList<Integer>();
        int i=0, j=0, max = Integer.MIN_VALUE;
        while(j < stockPrices.length) {
            if(stockPrices[j] >= stockPrices[i]) {
                profits.add(stockPrices[j]-stockPrices[i]);
                j++;
            } else {
                i = j;
            }
        }
        return profits;
    }
}
