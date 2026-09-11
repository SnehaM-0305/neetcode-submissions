class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length ; 

        int [][] dp = new int[2][n+2] ; 

        dp[0][n] = 0 ; 
        dp[1][n] = 0 ; 
        dp[0][n+1] = 0 ; 
        dp[1][n+1] = 0 ; 

        for(int i = n-1 ; i>=0 ; i--){
           //buy case 

           dp[1][i] = Math.max(dp[0][i+1] - prices[i] , dp[1][i+1]) ; 

           //sell case 

           dp[0][i] = Math.max(dp[1][i+2]+prices[i] , dp[0][i+1]) ; 


        }

        return dp[1][0] ; 
        
    }
}
