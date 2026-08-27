class Solution {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        var arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
        }
        return arr[n];
    }
}