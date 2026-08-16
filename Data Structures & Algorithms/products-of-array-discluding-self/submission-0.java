class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int countzero = 0 ; 
        int prod = 1 ; 
        for(int i = 0 ;i<nums.length;  i++)
        {
            if(nums[i]!=0){
                prod = prod*nums[i];
            }
            else{
                countzero++;
            }
        }
        for(int i =0 ; i<nums.length ; i++){
            if(nums[i]!=0 && countzero>0){
                res[i] = 0;
            }
            else if(nums[i]==0){
                if(countzero>1){
                    res[i]=0 ; 
                }
                else{
                    res[i]=prod;
                }
            }
            else{
                res[i]=prod/nums[i];
            }
        }
        return res ; 


    }
}  
