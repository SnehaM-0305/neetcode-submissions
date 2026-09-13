class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
          boolean [][] dp = new boolean[s1.length()+1][s2.length()+1] ; 
        if(s1.length()+s2.length()!=s3.length()){
            return false ; 
        }

        dp[s1.length()][s2.length()] = true ; 

        for(int j = s2.length()-1 ; j>=0 ; j--){
          
            if(s2.charAt(j)==s3.charAt(s1.length()+j) && dp[s1.length()][j+1])
            dp[s1.length()][j] = true ; 
        }

        for(int i = s1.length()-1 ; i>=0 ; i--){
             if(s1.charAt(i)==s3.charAt(s2.length()+i) && dp[i+1][s2.length()])
            dp[i][s2.length()] = true ;

        }

        for(int i = s1.length()-1 ; i>=0 ; i--){
            for(int j = s2.length()-1 ;j>=0 ; j--){

                dp[i][j] = (s1.charAt(i)==s3.charAt(i+j) && dp[i+1][j])||(s2.charAt(j)==s3.charAt(i+j)&&dp[i][j+1]) ; 
            }
        }

        return dp[0][0] ; 
    }
}
