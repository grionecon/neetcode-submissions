class Solution {
    class Edge {
        int p1;
        int p2;
        int diff;
        Edge(int p1, int p2, int diff) {
            this.p1 = p1;
            this.p2 = p2;
            this.diff = diff;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> {
            return a.diff - b.diff;
        });
        int[] coordinate = points[0];
        for (int i = 1; i < points.length; i++) {
                pq.add(new Edge(0, i, Math.abs(coordinate[0] - points[i][0]) + Math.abs(coordinate[1] - points[i][1])));
        }

        int num = 0;
        int sum = 0;
        boolean[] visited = new boolean[points.length];
        while (!pq.isEmpty() && num < points.length - 1) {
            Edge e = pq.remove();
            if (visited[e.p1]) {
                continue;
            }
            visited[e.p1] = true;
            num += 1;
            sum += e.diff;
            for (int i = 0; i < points.length; i++) {
                if (!visited[i]) {
                    pq.add(new Edge(e.p2, i, Math.abs(points[e.p2][0] - points[i][0]) + Math.abs(points[e.p2][1] - points[i][1])));
                }
            }
        }
        return sum;
    }
}
