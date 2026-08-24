/*
1dfs/bfs from any node to find the farthest node1
2dfs/bfs from node1 to find the farthest node2
3dfs/bfs to build path from node1 to node2
4middle of the path is the result
*/
public class Solution {
    private List<Integer>[] adjList;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        var res = new ArrayList<Integer>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        adjList = new List[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }
        var deepestFirst = dfs(0, -1);
        var deepestSecond = dfs(deepestFirst[0], -1);
        
        var path = dfs2(deepestFirst[0], -1, deepestSecond[0]);
        var size = path.size();
        if (size != 0) {
            res.add(path.get(size / 2));
            if (size % 2 == 0) {
                res.add(path.get(size / 2 - 1));
            }
        } 
        return res;
    }
    int[] dfs(int node, int parent) {
        var deepest = new int[]{node, 0};
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
    List<Integer> dfs2(int node, int parent, int target) {
        List<Integer> result = new ArrayList<Integer>();
        if (node == target) {
            result.add(node);
            return result;
        }
        for (var conn : adjList[node]) {
            if (conn != parent) {
                var list = dfs2(conn, node, target);
                if (list.size() > 0) {
                    result = list;
                    break;
                }
            }
        }
        if (result.size() > 0) {
            result.add(node);
        }
        return result;
    }
}