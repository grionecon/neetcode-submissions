class Solution {
    public int minimumEffortPath(int[][] heights) {
        var N = heights.length;
        var visited = new int[heights.length][];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = new int[heights[i].length];
            for (int j = 0; j < visited[i].length; j++) {
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        visited[0][0] = 0;
        var pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, 0, 0});
        var maxDiff = 0;
        while (!pq.isEmpty()) {
            var cell = pq.remove();
            var diff = cell[0];
            var r = cell[1];
            var c = cell[2];
            maxDiff = Integer.max(maxDiff, diff);
            if (r == N - 1 && c == heights[r].length - 1) {
                return maxDiff;
            }

            var dirs = new int[][]{
                new int[]{1, 0},
                new int[]{0, 1},
                new int[]{-1, 0},
                new int[]{0, -1}
                };
            for (var dir : dirs) {
                var newR = dir[0] + r;
                var newC = dir[1] + c;
                if (newR < N && newR >= 0 && newC < heights[newR].length && newC >= 0) {
                    var newDiff = Math.abs(heights[r][c] - heights[newR][newC]);
                    if (visited[newR][newC] > newDiff) {
                        visited[newR][newC] = newDiff;
                        pq.add(new int[]{newDiff, newR, newC});
                    }
                }
            }
        }
        return maxDiff;
    }
}