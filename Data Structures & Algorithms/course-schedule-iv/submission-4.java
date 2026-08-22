class Solution {
    List<Integer>[] adjList;
    int[] indegree;
    boolean[] visiting;
    boolean[] visited;
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        adjList = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList();
        }
        indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            adjList[prerequisites[i][0]].add(prerequisites[i][1]);
            indegree[prerequisites[i][1]] += 1;
        }
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            var start = queries[i][0];
            var finish = queries[i][1];
            visiting = new boolean[numCourses];
            visited = new boolean[numCourses];
            if (dfs(start, finish) == finish) {
                adjList[start].add(finish);
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }
    int dfs(int i, int target) {
        if (visited[i]) {
            return -1;
        }
        if (visiting[i]) {
            return -2;
        }
        if (i == target) {
            return target;
        }
        visiting[i] = true;
        for (var conn: adjList[i]) {
            if (!visited[conn]) {
                var res = dfs(conn, target);
                if (res == -2) {
                    return -2;
                } else if (res >= 0) {
                    return res;
                }
            }
        }
        visited[i] = true;
        visiting[i] = false;
        return -1;
    }
}