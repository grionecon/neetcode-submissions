class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Integer.max(nums[0], nums[1]);
        }
        return Math.max(helper(nums, 0, nums.length - 1), helper(nums, 1, nums.length));
    }
    int helper (int[] nums, int start, int finish) {
        var res = new int[nums.length];
        res[start] = nums[start];
        res[start + 1] = Integer.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i < finish; i++) {
            res[i] = Integer.max(nums[i] + res[i - 2], res[i - 1]);
        }
        return res[finish - 1];
    }
}
