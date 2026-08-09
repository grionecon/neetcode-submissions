class Solution {
    class Pair {
        int to;
        int distance;
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        var dict = new HashMap<Integer, List<int[]>>();
        for (int i = 1; i <= n; i++) {
            dict.put(i, new ArrayList());
        }
        for (int i = 0; i < times.length; i++) {
            dict.get(times[i][0]).add(new int[]{times[i][1], times[i][2]});
        }
        var visited = new HashSet<Integer>();
        var pq = new PriorityQueue<int[]>((a, b) -> {
            return a[0] - b[0]; 
        });
        pq.add(new int[] {0, k});
        int totalTime = 0;
        while (!pq.isEmpty()) {
            int[] pair = pq.remove();
            int edge = pair[1];
            if (visited.contains(edge)) {
                continue;
            }
            int weight = pair[0];
            visited.add(edge);
            totalTime = weight;
            for (var neighbors : dict.get(edge)) {
                if (!visited.contains(neighbors[0])) {
                    pq.add(new int[] {weight + neighbors[1], neighbors[0]});
                }
            }
        }
        return visited.size() == n ? totalTime : -1;
    }
}
