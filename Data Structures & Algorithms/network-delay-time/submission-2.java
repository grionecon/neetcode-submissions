class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        var dict = new HashMap<Integer, List<int[]>>();
        for (var time : times) {
            dict.put(time[0], new ArrayList<>());
        }
        for (var time : times) {
            dict.get(time[0]).add(new int[]{time[1], time[2]});
        }
        var visited = new HashSet<Integer>();
        var pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, k});
        var totalTime = 0;
        while (!pq.isEmpty()) {
            var pair = pq.remove();
            int edge = pair[1];
            int weight = pair[0];
            if (visited.contains(edge)) {
                continue;
            }
            visited.add(edge);
            totalTime = weight;
            if (!dict.containsKey(edge)) {
                continue;
            }
            for (var connections : dict.get(edge)) {
                if (!visited.contains(connections[0])) {
                    pq.add(new int[]{weight + connections[1], connections[0]});
                }
            }
        }
        return visited.size() == n ? totalTime : -1;
    }
}
