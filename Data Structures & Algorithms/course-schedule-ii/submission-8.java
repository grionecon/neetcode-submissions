class Solution {

    List<Integer>[] adjList;
    int[] indegree;
    List<Integer> output;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        adjList = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList<>();
        }
        indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            adjList[prerequisites[i][0]].add(prerequisites[i][1]);
            indegree[prerequisites[i][1]] += 1;
        }
        output = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                dfs(i);
            }
        }
        if (output.size() != numCourses) {
            return new int[0];
        }
        var result = new int[numCourses];
        for (int i = 0; i < result.length; i++) {
            result[i] = output.get(numCourses - i - 1);
        }
        return result;
    }
    public void dfs(int i) {
        output.add(i);
        indegree[i] -= 1000;
        for (var conn : adjList[i]) {
            indegree[conn] -= 1;
            if (indegree[conn] == 0) {
                dfs(conn);
            }
        }
    }
}
