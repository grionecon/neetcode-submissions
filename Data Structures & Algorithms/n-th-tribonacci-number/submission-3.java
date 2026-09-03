class Solution {
    public int tribonacci(int n) {
        var t0 = 0;
        var t1 = 1;
        var t2 = 1;
        for (int i = 2; i < n; i++) {
            var tmp = t2 + t1 + t0;
            t0 = t1;
            t1 = t2;
            t2 = tmp;
        }
        return t2;
    }
}