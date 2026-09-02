class Solution {
    public int coinChange(int[] coins, int amount) {
        // dp[i]-->number of coins needed to form that particular amount
       int[][] dp = new int[coins.length][amount + 1];
       for (int[] row : dp) {
    Arrays.fill(row, -1);
}
        int res = solve(coins, amount, 0, dp);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public int solve(int[] coins, int leftamount, int pos, int[][] dp) {
        if (leftamount == 0) {
            return 0;
        }

        if (pos >= coins.length || leftamount < 0) {
            return Integer.MAX_VALUE;
        }

        if (dp[pos][leftamount] != -1) {
            return dp[pos][leftamount];
        }

        // take the coin

        int take = Integer.MAX_VALUE;
        if (leftamount >= coins[pos]) {
            take = solve(coins, leftamount - coins[pos], pos, dp);

            if (take != Integer.MAX_VALUE) {
                take = take + 1;
            }
        }

        // not take

        int notTake = solve(coins, leftamount, pos + 1, dp);
        dp[pos][leftamount] = Math.min(take, notTake);
        return dp[pos][leftamount];
    }
}
