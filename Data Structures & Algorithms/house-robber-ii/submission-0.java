class Solution {
    public int rob(int[] nums) {
        int result = new int[nums.length];
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Integer.max(nums[0], nums[1]);
        }
    }
}
