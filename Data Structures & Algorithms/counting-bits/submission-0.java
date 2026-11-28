class Solution {
    public int solve(int num){
         int ans = 0 ; 
       
        while(num!=0){
            if(num%2!=0){
                ans++;
                 
            }
            num = num/2 ;
        }
        return ans ; 
    }
    public int[] countBits(int n) {
        int [] res = new int[n+1] ; 
        for(int i = 0 ; i<=n;i++){
            res[i] = solve(i) ; 
        }

        return res ; 
    }
}
