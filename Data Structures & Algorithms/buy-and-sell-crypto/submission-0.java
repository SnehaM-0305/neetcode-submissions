class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length ; 
        int buy = prices[0] ; 
        int maxprofit = 0 ;
int i = 1 ; 
        while(i<n){
            if(prices[i]<buy)
            {
buy = prices[i];
            }
            else{
                int profit = prices[i]-buy ; 
                maxprofit = Math.max(profit , maxprofit);

            }
            i++;
        }
        return maxprofit;

    }
}
