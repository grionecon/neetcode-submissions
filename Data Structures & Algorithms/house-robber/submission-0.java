class Solution {
    public int rob(int[] nums) {
        if (nums.length < 3) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        int r0 = nums[0];
        int r1 = nums[1];
        int r2 = nums[2] + r0;
        if (nums.length == 3) {
            if (r1 > r2) {
                return r1;
            } 
            return r2;
        }
        for (int i = 3; i < nums.length; i++) {
            var tmp = nums[i] + Integer.max(r1, r0);
            r0 = r1;
            r1 = Integer.max(r2, tmp);
            r2 = tmp;
        }
        return r1;
    }
}
