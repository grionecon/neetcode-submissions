class Solution {
    public int rob(int[] nums) {
        if (nums.length == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        if (nums.length == 1) {
            return nums[0];
        }
        var result = new int[nums.length];
        
        
        var r1 = nums[0];
        var r2 = Integer.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            var max = Integer.max(r1 + nums[i], r2);
            r1 = r2;
            r2 = max;
        }
        return r2;
    }
}
