class Solution {
    public int hammingWeight(int n) {

        int ans = 0 ; 
        int num = n ; 
        while(num!=0){
            if(num%2!=0){
                ans++;
                 
            }
            num = num/2 ;
        }
        return ans ; 
        
    }
}
