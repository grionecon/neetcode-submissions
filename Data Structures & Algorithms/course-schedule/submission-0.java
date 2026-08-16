class Solution {
    Set<Integer> visited;
    ArrayList<Integer>[] adjList;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        adjList = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adjList[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        for (int i = 0; i < numCourses; i++) {
            visited = new HashSet<Integer>();
            var result = dfs(i);
            if (!result) {
                return false;
            }
        }
        return true;
    }
    boolean dfs(int node) {
        if (visited.contains(node)) {
            return false;
        }
        visited.add(node);
        var success = true;
        for (int i = 0; i < adjList[node].size(); i++) {
            success = success && dfs(adjList[node].get(i));
        }
        return success;
    }
}
