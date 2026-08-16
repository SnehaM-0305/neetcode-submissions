class Solution {
   public int searchhelper(int[] nums, int start, int end, int target) {

        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return searchhelper(nums, start, mid - 1, target);
        } else {
            return searchhelper(nums, mid + 1, end, target);
        }
    }
    public int search(int[] nums, int target) {
     return searchhelper(nums, 0, nums.length - 1, target);
    }
}
