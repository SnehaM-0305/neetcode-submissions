class Solution {
    public int numDecodings(String s) {
        int[] dp =new int [s.length()]  ; 
        Arrays.fill(dp,-1) ; 
        int res = solve(s,0,dp) ; 
        return res ; 
    }

    public int solve(String s , int pos , int [] dp){
        if(pos ==s.length()){
            return 1 ; 
        }

        if(s.charAt(pos)=='0'){
            return 0 ; 
        }

        if(dp[pos]!=-1){
            return dp[pos] ; 
        }

        //take one digit 

        int ways = solve(s, pos+1,dp);
        if(pos+1<s.length()){
            int num = Integer.parseInt(s.substring(pos,pos+2)) ; 
            if(num>=10 && num<=26){
                ways +=solve(s,pos+2,dp) ; 
            }
        }
       dp[pos] = ways ; 
       return dp[pos] ; 
    }
}
