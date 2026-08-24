public class Solution {
    private List<Integer>[] adjList;

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
        var deepestFirst = dfs(0, -1);
        var deepestSecond = dfs(deepestFirst[0], -1);

    }
    int[] dfs(int node, int parent) {
        var deepest = new int[2];
        for (var conn : adjList[node]) {
            if (conn != parent) {
                var tmp = dfs(conn, node);
                if (tmp[1] > deepest[1]) {
                    deepest = tmp;
                }
            }
        }
        deepest[1] += 1;
        return deepest;
    }
    ArrayList<Integer> dfs2(int node, int parent, int target) {
        if (node == target) {
            var result = new ArrayList<Integer>();
            result.append(target);
            return result;
        }
        for (var conn : adjList[node]) {
            if (conn != parent) {
                var list = dfs(conn, node, target);
                if (list.length > 0) {
                    return list;
                }
            }
        }
        return result;
    }
}