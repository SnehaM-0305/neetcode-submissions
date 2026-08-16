class Solution {
    public int findMin(int[] nums) {
        int n = nums.length ; 
        int pivot = 0 ; 
        
       for(int i = 1 ; i<n ; i++){
        if(nums[i]<nums[i-1])
        {
            pivot = i ; 
        }
       }
       return nums[pivot];
    }
}
