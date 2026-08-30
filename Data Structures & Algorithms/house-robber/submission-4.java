class Solution {
    public int rob(int[] nums) {
        if (nums.length == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        if (nums.length == 1) {
            return nums[0];
        }
        var result = new int[nums.length];
        result[0] = nums[0];
        result[1] = Integer.max(nums[1], nums[0]);
        
        for (int i = 2; i < nums.length; i++) {
            result[i] = Integer.max(nums[i] + result[i-2], result[i-1]);
        }
        return result[nums.length - 1];
    }
}
