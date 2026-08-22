class Solution {
    List<Integer>[] adjList;
    Map<Integer, Set<Integer>> prereqMap;
    int[] indegree;
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        adjList = new ArrayList[numCourses];
        prereqMap = new HashMap<>();
        indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList();
            prereqMap.putIfAbsent(i, new HashSet<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adjList[prerequisites[i][0]].add(prerequisites[i][1]);
            prereqMap.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][1]] += 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            var node = queue.remove();
            for (var conn : adjList[node]) {
                indegree[conn] -= 1;
                Set<Integer> connMap = prereqMap.get(conn);
                connMap.addAll(prereqMap.get(node));
                if (indegree[conn] == 0) {
                    queue.add(conn);
                }
            }
        }
        var result = new LinkedList<Boolean>();
        for (int i = 0; i < queries.length; i++) {
            result.add(prereqMap.get(queries[i][1]).contains(queries[i][0]));
        }
        return result;
    }
}