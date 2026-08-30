class Solution {
    public int rob(int[] nums) {
        var r1 = 0;
        var r2 = 0;
        for (int i = 0; i < nums.length; i++) {
            var tmp = Integer.max(nums[i] + r1, r2);
            r1 = r2;
            r2 = tmp;
        }
        return r2;
    }
}
