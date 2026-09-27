class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 0;

        for (int i = nums.length - 2; i >= 0; i--) {
            int min = Integer.MAX_VALUE;

            for (int j = 1; j + i < nums.length && j <= nums[i]; j++) {
                if (dp[i + j] != Integer.MAX_VALUE) {
                    min = Math.min(min, dp[i + j] + 1);
                }
            }

            dp[i] = min;  
        }

        return dp[0];
    }
}