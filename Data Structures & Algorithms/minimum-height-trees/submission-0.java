/*Not exactly a classic topological sort. 
Typical problem names: Finding tree center, Peeling the tree
*/
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer>[] adjList = new LinkedList[n];
        var leaves = new Hash<Integer>();
        for (int i = 0; i < n; i++) {
            adjList[i] = new LinkedList<>();
            leaves.add(i);
        }
        
        for (int i = 0; i < edges.length; i++) {
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }
        var connLevels = new int[n];
        var queue = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            connLevels[i] = adjList[i].length();
            if (connLevels[i] == 1) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            if ()
            var node = queue.remove();
            n -= 1;
            for (var conn: adjList[node]) {
                connLevels[conn]
            }
        }
    }
    
}