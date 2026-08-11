class Solution {
    class Pair {
        int node;
        double probability;
        Pair(int node, double probability) {
            this.node = node;
            this.probability = probability;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        var list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            var pair = new Pair(edges[i][1], succProb[i]);
            list[edges[i][0]].add(pair);
            
            pair = new Pair(edges[i][0], succProb[i]);
            list[edges[i][1]].add(pair);
        }
        
        var pq = new PriorityQueue<Pair>((a, b) -> {
            var res = b.probability - a.probability;
            if (res > 0) {
                return 1;
            } else if (res == 0) {
                return 0;
            } 
            return -1;
    });
        var visited = new double[n];
        pq.add(new Pair(start_node, 1.0));
        while (!pq.isEmpty()) {
            var currPair = pq.remove();
            if (visited[currPair.node] < currPair.probability) {
                visited[currPair.node] = currPair.probability;
            } else {
                continue;
            }
            if (currPair.node == end_node) {
                return visited[currPair.node];
            }
            for (var p: list[currPair.node]) {
                var pair = (Pair)p;
                var tmpProb = currPair.probability * pair.probability;
                if (visited[pair.node] < tmpProb) {
                    pq.add(new Pair(pair.node, tmpProb));
                }
            }
        }
        return 0;
    }
}