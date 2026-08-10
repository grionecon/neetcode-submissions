class Solution {
    public int swimInWater(int[][] grid) {
        var N = grid.length;
        var visited = new boolean[N][N];
        var pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{grid[0][0], 0, 0});
        while(!pq.isEmpty()) {
            var pair = pq.remove();
            var level = pair[0];
            var r = pair[1];
            var c = pair[2];
            if (r == N - 1 && c == N - 1) {
                return level;
            }
            visited[r][c] = true;
            var dirs = new int[][] {
                new int[]{1, 0},
                new int[]{0, 1},
                new int[]{-1, 0},
                new int[]{0, -1}
            };
            for (var dir : dirs) {
                int newR = r + dir[0];
                int newC = c + dir[1];
                if (newR >= 0 && newC >= 0 && newR < N && newC < N && !visited[newR][newC]) {
                    pq.add(new int[]{Integer.max(level, grid[newR][newC]), newR, newC});
                }
            }
        }
        return -1;
    }
}
