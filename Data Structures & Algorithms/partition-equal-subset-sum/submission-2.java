class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for (int x : nums) {
            totalSum += x;
        }

        if (totalSum % 2 != 0) {
            return false;
        }

        int sum = totalSum / 2;

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        if (nums[0] <= sum) {
            dp[nums[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int s = sum; s >= 0; s--) {
                if (s - nums[i] >= 0) {
                    dp[s] = dp[s] || dp[s - nums[i]];
                }
                // else: dp[s] stays as is (notTake, same as before)
            }
        }

        return dp[sum];
    }
}