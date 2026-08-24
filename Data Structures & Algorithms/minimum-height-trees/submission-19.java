/*
4. Topological Sorting (BFS)
Something Like Topological Sorting (BFS)
Association: like peeling the onion: Clear each leaf(node with 1 connection). When there are 1 or 2 nodes left - they are the middle (of the onion).
*/
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Arrays.asList(0);
        }
        List<Integer>[] adjList = new List[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }
        var connLevels = new int[n];
        var queue = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            connLevels[i] = adjList[i].size();
            if (connLevels[i] == 1) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            if (n <= 2) {
                return queue;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                var node = queue.remove();
                n -= 1;
                for (var conn : adjList[node]) {
                    connLevels[conn] -= 1;
                    if (connLevels[conn] == 1) {
                        queue.add(conn);
                    }
                }
            }
        }
        return new ArrayList<>();
    }
}