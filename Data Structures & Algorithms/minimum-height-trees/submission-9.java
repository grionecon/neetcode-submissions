public class Solution {
    private List<Integer>[] adj;
    private List<Integer> centroids;
    private int nodeB;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1)
            return Collections.singletonList(0);

        adj = new ArrayList[n];
        for (int i = 0; i < n; ++i)
            adj[i] = new ArrayList<>();

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        int nodeA = dfs(0, -1)[0];
        var secondDFS = dfs(nodeA, -1);
        nodeB = secondDFS[0];
        centroids = new ArrayList<>();
        findCentroids(nodeA, -1);

        int L = centroids.size();
        if (secondDFS[1] % 2 == 0) {
            return Collections.singletonList(centroids.get(L / 2));
        } else {
            return Arrays.asList(centroids.get(L / 2 - 1), centroids.get(L / 2));
        }
    }

    private int[] dfs(int node, int parent) {
        int farthestNode = node, maxDistance = 0;
        for (int neighbor : adj[node]) {
            if (neighbor != parent) {
                int[] res = dfs(neighbor, node);
                if (res[1] + 1 > maxDistance) {
                    maxDistance = res[1] + 1;
                    farthestNode = res[0];
                }
            }
        }
        return new int[] { farthestNode, maxDistance };
    }

    private boolean findCentroids(int node, int parent) {
        if (node == nodeB) {
            centroids.add(node);
            return true;
        }
        for (int neighbor : adj[node]) {
            if (neighbor != parent) {
                if (findCentroids(neighbor, node)) {
                    centroids.add(node);
                    return true;
                }
            }
        }
        return false;
    }
}