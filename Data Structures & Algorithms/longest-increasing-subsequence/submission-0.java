class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        for (int i = 0; i < lis.length; i++) {
            lis[i] = 1;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    lis[i] = Integer.max(lis[i], 1 + lis[j]);
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (lis[0] < lis[i]) {
                lis[0] = lis[i];
            }
        }
        return lis[0];
    }
}
