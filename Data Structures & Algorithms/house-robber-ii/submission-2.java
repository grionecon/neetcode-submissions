class Solution {
    public int rob(int[] nums) {
        var res = new int[nums.length];
        if (nums.length == 1) {
            return nums[0];
        }
        res[0] = nums[0];
        res[1] = Integer.max(nums[0], nums[1]);
        int[] indexArr = new int[res.length];
        if (nums[0] > nums[1]) {
            indexArr[1] = 0;
        }
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] + res[i - 2] > res[i - 1]) {
                indexArr[i] = i - 2;
            } else {
                indexArr[i] = i - 1;
            }
            res[i] = Integer.max(nums[i] + res[i - 2], res[i - 1]);
        }
        if (res[res.length - 1] > res[res.length - 2]) {
            var i = res.length - 1;
            while (indexArr[i] != i) {
                i = indexArr[i];
            }
            if (i == 0) {
                return res[res.length - 2];
            }
        }
        return res[res.length - 1];
    }
}
