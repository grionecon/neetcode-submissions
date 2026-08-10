class Solution {
    public int swimInWater(int[][] grid) {
        var pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        int N = grid.length;
        boolean[][] visited = new boolean[N][N];
        int maxLevel = 0;
        
        pq.add(new int[]{grid[0][0], 0, 0});
        var directions = new int[][]{
            new int[]{0, 1}, 
            new int[]{1, 0},
            new int[]{-1, 0},
            new int[]{0, -1}
            };

        while (!pq.isEmpty()) {
            var pair = pq.remove();
            var level = pair[0];
            var r = pair[1];
            var c = pair[2];
            if (visited[r][c]) {
                continue;
            }
            visited[r][c] = true;
            if (r == N - 1 && c == N - 1) {
                return Integer.max(maxLevel, level);
            }
            maxLevel = level;
            for (var dir: directions) {
                int nextR = r + dir[0];
                int nextC = c + dir[1];
                if (nextR < N && nextR >=0 && nextC < N && nextC >= 0 && !visited[nextR][nextC]) {
                    pq.add(new int[]{Integer.max(maxLevel, grid[nextR][nextC]), nextR, nextC});
                }
            }
        }
        return N * N;
        
    }
}
