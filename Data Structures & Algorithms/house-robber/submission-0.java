class Solution {
    public int rob(int[] nums) {
        int n = nums.length ; 

        int [] dp = new int[n+1] ; 

        dp[0] = 0 ; 

    if(n>=1){
        dp[1] = nums[0] ; 
    }

    for(int i = 2 ; i<n+1 ; i++){
         //rob the house 

        int rob= nums[i-1]+dp[i-2] ; 

         //dont rob the house 

         int skip = dp[i-1] ; 

         dp[i] = Math.max(rob,skip) ; 
    }

    return dp[n] ; 
    }
}
