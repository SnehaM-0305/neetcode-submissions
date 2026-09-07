class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
                Boolean[] dp = new Boolean[s.length() + 1];

        return solve(s,0,wordDict ,dp) ; 
    }

    public boolean solve(String s , int pos , List<String> wordDict , Boolean [] dp){

        if(pos==s.length()){
            return true ; 
        }

        if(dp[pos]!=null){
            return dp[pos] ; 
        }

        for(String word:wordDict){

            int n = word.length() ; 

            if(pos+n<=s.length()){

                if(s.substring(pos,pos+n).equals(word)){
                     if(solve(s,pos+n , wordDict , dp)){
                        dp[pos] = true ; 
                        return dp[pos] ; 
                     } 
                }
            }
        }
        dp[pos] =  false ; 
        return dp[pos] ; 
    }
}
