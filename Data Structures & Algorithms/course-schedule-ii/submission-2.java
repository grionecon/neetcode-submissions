class Solution {
    Set<Integer> visiting;
    Set<Integer> visited;
    List<Integer>[] adjList;
    List<Integer> result;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        adjList = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adjList[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        visiting = new HashSet<>();
        visited = new HashSet<>();
        result = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) {
                return new int[0];
            }
        }
        if (visiting.size() != 0) {
            return new int[0];
        }
        int[] resultArr = new int[result.size()];        
        for (int i = 0; i < resultArr.length; i++) {
            resultArr[i] = result.get(i);
        }
        return resultArr;
    }
    boolean dfs(int node) {
        if (visiting.contains(node)) {
            return false;
        }
        if (visited.contains(node)) {
            return true;
        }
        visiting.add(node);
        for (var connection: adjList[node]) {
            if (!dfs(connection)) {
                return false;
            }
        }
        visiting.remove(node);
        result.add(node);
        visited.add(node);
        return true;
    }

}
