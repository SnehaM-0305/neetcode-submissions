class Solution {
    public int uniquePaths(int m, int n) {
        int [][] dp = new int[m][n] ; 
        for(int [] row :dp){
            Arrays.fill(row , -1) ; 
        }
        return solve(0,0,m-1 ,n-1 , dp) ; 
        
    }

    public int solve(int i,int j , int endi , int endj , int [][] dp){
        //base case 

        if(i==endi && j==endj){
            return 1 ; 
        }

        if(i>endi || j>endj){
            return 0 ; 
        }

        if(dp[i][j]!=-1){
            return dp[i][j] ; 
        }

        //recursion 

        int path1 = solve(i,j+1,endi,endj ,dp) ; 
        int path2 = solve(i+1 , j , endi,endj,dp) ; 

        dp[i][j] =  path1+path2 ; 
        return dp[i][j] ; 
    }
}
