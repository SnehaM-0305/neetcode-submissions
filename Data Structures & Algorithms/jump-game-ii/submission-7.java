class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return solve(nums, 0, dp);
    }

    public int solve(int[] nums, int i, int[] dp) {
        // base case

        if (i == nums.length - 1) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        // work

        int min = Integer.MAX_VALUE;

        for (int j = 1; j + i < nums.length && j<=nums[i]; j++) {
           int childres = solve(nums,i+j,dp) ; 

           if(childres!=Integer.MAX_VALUE){
 min = Math.min(min, childres + 1);
           }

           
           
        }

        dp[i] = min;
        return dp[i];
    }
}
