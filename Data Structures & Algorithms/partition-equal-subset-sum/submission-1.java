class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
       
        int totalSum = 0;
        int sum = 0;
        for (int x : nums) {
            totalSum += x;
        }

        if (totalSum % 2 != 0) {
            return false;
        }

        else {
            sum = totalSum / 2;
        }

          int [][]dp = new int[sum+1][n] ;

          for(int [] arr :dp){
            Arrays.fill(arr,-1) ; 
          }

      return  solve(nums, sum, 0 , dp);

    }

    public boolean solve(int[] nums, int sum, int idx , int[][] dp) {
        if (sum == 0) {
            return true;
        }

        if (idx >= nums.length && sum != 0) {
            return false;
        }

        if(dp[sum][idx]!=-1){
            if(dp[sum][idx]==0){
                return false ; 
            }
            else{
                return true ; 
            }
        }




        // take
        boolean take = false;

        if (sum - nums[idx] >= 0) {
            take= solve(nums, sum - nums[idx], idx + 1 , dp);
        }

        // not take

        boolean notTake = solve(nums, sum, idx + 1 , dp);

       if(take||notTake){
        dp[sum][idx] = 1 ; 
       }

       else{
        dp[sum][idx] = 0 ; 
       }

       return take||notTake ; 
    }
}
