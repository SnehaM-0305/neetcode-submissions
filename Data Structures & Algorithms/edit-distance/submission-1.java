class Solution {
    public int minDistance(String word1, String word2) {
        int [][] dp = new int [word1.length()+1][word2.length()+1] ; 
        for(int[] arr:dp){
            Arrays.fill(arr,-1) ; 
        }
        return solve(0,0,word1,word2,dp) ; 
    }

    public int solve(int i , int j , String s , String t,int [][] dp){
        //base case 

        if(j==t.length()){
            return s.length()-i ; 
        }
        if(i==s.length()){
            return t.length()-j ; 
        }
        if(dp[i][j]!=-1){
            return dp[i][j] ; 
        }

        if(s.charAt(i)==t.charAt(j)){
            dp[i][j] =  solve(i+1 , j+1 , s,t,dp) ; 
            return dp[i][j] ; 
        }
        else{
            //replace 
            int insert = solve(i,j+1,s,t,dp) ; 

            //delte
            int delete = solve(i+1 , j , s,t,dp) ;  

            //replace 

            int replace = solve(i+1 , j+1 , s, t,dp) ; 

            dp[i][j] =  Math.min(Math.min(insert,delete) , replace)+1 ; 
            return dp[i][j] ; 
        }
    }
}
