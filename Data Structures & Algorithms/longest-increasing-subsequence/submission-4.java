class Solution {
    public int lengthOfLIS(int[] nums) {
        var dp = new int[nums.length];
        var max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Integer.max(dp[i], dp[j] + 1);
                }
            }
            max = Integer.max(max, dp[i]);
        }
        return max + 1;
    }
}
