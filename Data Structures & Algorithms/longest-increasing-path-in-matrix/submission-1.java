class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int max_Path = Integer.MIN_VALUE ; 

        int[][] dp = new int[matrix.length][matrix[0].length] ; 

        for(int i = 0 ; i<matrix.length ; i++){
            for(int j = 0 ; j<matrix[0].length ; j++){
                max_Path = Math.max(max_Path,solve(i,j , matrix , dp));
            }
        }
        return  max_Path;
        
    }

    public int solve(int i , int j , int[][] m , int[][] dp){
        //base case 

  if(dp[i][j]!=0){
    return dp[i][j] ; 
  }

        // recursive call 

    int best = 1 ;  

        if(i+1<m.length && m[i+1][j]>m[i][j]){
            best = Math.max(best , solve(i+1 , j , m , dp)+1  );
        }

        if(i-1>=0 && m[i-1][j]>m[i][j]){
           best = Math.max(best , solve(i-1 , j , m , dp)+1) ; 
        }
        if(j+1<m[0].length && m[i][j+1]>m[i][j]){
           best = Math.max(best , solve(i,j+1 , m , dp)+1) ; 
        }
        if(j-1>=0 && m[i][j-1]>m[i][j]){
          best = Math.max(best , solve(i,j-01,m , dp)+1) ; 
        }
dp[i][j] = best ; 
        return best ;  


    }
}
