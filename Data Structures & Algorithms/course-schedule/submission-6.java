class Solution {
    Set<Integer> visiting;
    ArrayList<Integer>[] adjList;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        adjList = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adjList[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        visiting = new HashSet<Integer>();
        for (int i = 0; i < numCourses; i++) {
            var result = dfs(i);
            if (!result) {
                return false;
            }
        }
        return true;
    }
    boolean dfs(int node) {
        if (visiting.contains(node)) {
            return false;
        }
        if (adjList[node].size() == 0) {
            return true;
        }
        visiting.add(node);
        var success = true;
        for (int i = 0; i < adjList[node].size(); i++) {
            if (!dfs(adjList[node].get(i))) {
                return false;
            }
        }
        // visiting.remove(node);
        // adjList[node] = new ArrayList<>();
        return success;
    }
}
