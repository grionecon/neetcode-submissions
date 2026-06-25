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
    int[] rank;
    int[] root;
    public int minCostConnectPoints(int[][] points) {
        rank = new int[points.length];
        root = new int[points.length];
        for (int i = 0; i < rank.length; i++) {
            root[i] = i;
            rank[i] = 1;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> {
            return a.diff - b.diff;
        });
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                pq.add(new Edge(i, j, Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1])));
            }
        }
        int num = 0;
        int sum = 0;
        while (num < points.length - 1) {
            Edge e = pq.remove();
            if (!isConnected(e.p1, e.p2)) {
                num += 1;
                sum += e.diff;
                connect(e.p1, e.p2);
            }
        }
        return sum;
    }
    void connect(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rank[rootX] > rank[rootY]) {
            root[rootY] = rootX;
        } else if (rank[rootY] > rank[rootX]) {
            root[rootX] = rootY;
        } else {
            root[rootY] = rootX;
            rank[rootX] += 1;
        }
    }
    boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
    int find(int x) {
        if (root[x] != x) {
            root[x] = find(root[x]);
            return root[x];
        }
        return root[x];
    }
}
