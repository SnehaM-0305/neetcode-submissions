class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        
        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            maxLen = Math.max(maxLen, LIS(nums, i, memo));
        }
        return maxLen;
    }
    
    private int LIS(int[] nums, int i, int[] memo) {
        if (memo[i] != -1) return memo[i]; 
        
        int best = 1; 
        
        for (int k = 0; k < i; k++) {
            if (nums[k] < nums[i]) {
                best = Math.max(best, LIS(nums, k, memo) + 1);
            }
        }
        
        memo[i] = best; 
        return memo[i];
    }
}