class Solution {
    public int change(int amount, int[] coins) {

        int n = coins.length ; 

        int[][] dp = new int[n+1][amount+1] ; 

        for(int i = 0 ; i<=n ; i++){
            dp[i][0] = 1 ; 
        }

        for(int i = 1 ; i <=amount ; i++){
            dp[n][i] = 0 ; 
        }

      for(int i = n-1 ; i>=0 ; i--){
    for(int j = 0 ; j<=amount ; j++){
  int takeways = 0;
if (j - coins[i] >= 0) {
    takeways = dp[i][j - coins[i]];
}
dp[i][j] = dp[i+1][j] + takeways;
    }
}

        return dp[0][amount];
        
    }
}
