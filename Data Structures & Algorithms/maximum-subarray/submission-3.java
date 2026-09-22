class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(nums[i] + dp[i + 1], nums[i]);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}