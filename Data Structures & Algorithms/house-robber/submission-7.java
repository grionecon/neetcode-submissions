class Solution {
    public int rob(int[] nums) {
        var res = new int[nums.length];
        if (nums.length == 1) {
            return nums[0];
        }
        res[0] = nums[0];
        res[1] = Integer.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            res[i] = Integer.max(nums[i] + res[i - 2], res[i - 1]);
        }
        return res[nums.length - 1];
    }
}