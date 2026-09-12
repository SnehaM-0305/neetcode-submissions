

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int total = 0;
        for (int num : nums) total += num;

        // edge case: unreachable target
        if (Math.abs(target) > total) return 0;

        int[][] dp = new int[n + 1][2 * total + 1];

        // base case: i == n row
        dp[n][total] = 1;  // remaining == 0 (shifted)
        // all other dp[n][r] stay 0 by default

        for (int i = n - 1; i >= 0; i--) {
            for (int r = 0; r <= 2 * total; r++) {
                int addWays = 0;
                if (r - nums[i] >= 0) {
                    addWays = dp[i + 1][r - nums[i]];
                }
                int subtractWays = 0;
                if (r + nums[i] <= 2 * total) {
                    subtractWays = dp[i + 1][r + nums[i]];
                }
                dp[i][r] = addWays + subtractWays;
            }
        }

        return dp[0][target + total];  // shifted index for remaining = target
    }
}