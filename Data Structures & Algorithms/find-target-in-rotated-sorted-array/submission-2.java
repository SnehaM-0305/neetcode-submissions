class Solution {
    public int BinarySearch(int[] nums, int target, int start, int end) {
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target && start<=mid-1) {
            return BinarySearch(nums, target, start, mid - 1);
        } else if (nums[mid] < target && mid+1<=end) {
            return BinarySearch(nums, target, mid + 1, end);
        }
        else{return -1;}
        
    }
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n==1 && nums[0]==target){
           
                return 0;
            
        }
        if(n==1 && nums[0]!=target){
           
                return -1;
            
        }

        int pivot = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                pivot = i - 1;
            }
        }

        if(nums[0]<=target && target<=nums[pivot]){
           return  BinarySearch(nums,target,0,pivot);
        }
        else {
            return BinarySearch(nums,target,pivot+1,n-1);
        }
       
    }
}
