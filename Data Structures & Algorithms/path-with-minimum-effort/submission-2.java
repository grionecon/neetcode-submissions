class Solution {
    public int minimumEffortPath(int[][] heights) {
        var N = heights.length;
        var visited = new int[heights.length][];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = new int[heights.length];
            for (int j = 0; j < visited[i].length; j++) {
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        var pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        var diff = heights[0][0];
        pq.add(new int[]{Math.abs(heights[0][0]), 0, 0});
        var maxDiff = 0;
        while (!pq.isEmpty()) {
            var cell = pq.remove();
            var r = cell[1];
            var c = cell[2];
            var dirs = new int[][]{
                new int[]{1, 0},
                new int[]{0, 1},
                new int[]{-1, 0},
                new int[]{0, -1}
                };
            diff = Math.abs(cell[0] - heights[r][c]);
            if (visited[r][c] > diff) {
                visited[r][c] = diff;
                maxDiff = Integer.max(maxDiff, diff);
            }
            if (r == N -1 && c == N - 1) {
                return maxDiff;
            }
            for (var dir : dirs) {
                var newR = dir[0] + r;
                var newC = dir[1] + c;
                if (newR < N && newR >= 0 && newC < heights[newR].length && newC >= 0) {
                    var c1 = cell[0];
                    diff = Math.abs(c1 - heights[newR][newC]);
                    if (visited[newR][newC] > diff) {
                        visited[newR][newC] = diff;
                        pq.add(new int[]{diff, newR, newC});
                    }
                }
            }
        }

        return maxDiff;
    }
}