class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int [][] dp = new int[s1.length()][s2.length()] ; 
        if(s1.length()+s2.length()!=s3.length()){
            return false ; 
        }
        return solve(0 ,0 ,   s1 ,  s2 ,  s3 ,dp) ; 
    }

    public boolean solve(int i , int j ,  String s1 , String s2 , String s3,int [][] dp){

        //base case 

        if(i==s1.length() ){
            return compare(j,i+j,s2,s3) ; 
        }

        if(j==s2.length() ){
            return compare(i,i+j,s1,s3) ; 
        }

        if(dp[i][j]!=0){
            return dp[i][j]==-1?false :true ;
        }

        //recursinve call 

        boolean take_froms1 = false ; 
        boolean take_froms2 = false ; 

        if(s1.charAt(i)==s3.charAt(i+j) && solve(i+1 , j , s1,s2,s3,dp)) {
            take_froms1 = true ; 
        }

        if(s2.charAt(j)==s3.charAt(i+j) &&solve(i,j+1 , s1,s2,s3,dp)){
            take_froms2 = true ; 
        }

        boolean val =  take_froms1||take_froms2 ;
        if(val){
            dp[i][j]=1 ; 
        } 
        else{
            dp[i][j] = -1 ; 
        }

        return val ; 
    }

    public boolean compare(int n , int m , String s , String t){

   return s.substring(n).equals(t.substring(m));}
}
