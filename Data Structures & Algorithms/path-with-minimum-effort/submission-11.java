class Solution {
    public int minimumEffortPath(int[][] heights) {
        var N = heights.length;
        var M = heights[0].length;
        var visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        visited[0][0] = 0;
        var pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, 0, 0});
        var dirs = new int[][]{
                new int[]{1, 0},
                new int[]{0, 1},
                new int[]{-1, 0},
                new int[]{0, -1}
        };
        while (!pq.isEmpty()) {
            var cell = pq.remove();
            var diff = cell[0];
            var r = cell[1];
            var c = cell[2];
            if (r == N - 1 && c == M - 1) {
                return diff;
            }
            if (visited[r][c] < diff) {
                continue;
            }
            for (var dir : dirs) {
                var newR = dir[0] + r;
                var newC = dir[1] + c;
                if (newR < N && newR >= 0 && newC < M && newC >= 0) {
                    var newDiff = Integer.max(diff, Math.abs(heights[r][c] - heights[newR][newC]));
                    if (visited[newR][newC] > newDiff) {
                        visited[newR][newC] = newDiff;
                        pq.add(new int[]{newDiff, newR, newC});
                    }
                }
            }
        }
        return 0;
    }
}