class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // base case: every element alone has length 1
        
        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < i; k++) {
                if (nums[k] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[k] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        
        return maxLen;
    }
}