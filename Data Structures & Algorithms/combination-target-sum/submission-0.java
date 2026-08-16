class Solution {
    public List<List<Integer>> finalAns = new ArrayList<>();
    public void comSum(int[] nums, int target, List<Integer> ans, int i) {
        if (target == 0) {
            finalAns.add(new ArrayList<>(ans));
            return;
        }
        if (target < 0 || i >= nums.length) {
            return;
        }

        // include
        ans.add(nums[i]);
        comSum(nums, target - nums[i], ans, i);
        ans.remove(ans.size() - 1);

        // exclude

        comSum(nums, target, ans, i + 1);

        // backtrack

    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        comSum(nums, target, new ArrayList<>(), 0);
        return finalAns;
    }
}
