class Solution {
    public int lengthOfLIS(int[] nums) {
        var dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        var max = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Integer.max(dp[i], dp[j] + 1);
                }
            }
            max = Integer.max(max, dp[i]);
        }
        return max;
    }
}
