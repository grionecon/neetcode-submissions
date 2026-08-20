class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = new ArrayList()[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList<>();
        }
        var indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            adjList[prerequisites[i][0]].add(prerequisites[i][1]);
            indegree[prerequisites[i][1]] += 1;
        }
        Queue<Integer> queue = new ArrayList<>();
        for (int i = 0; i < adjList.length; i++) {
            if (adjList.size() == 0) {
                queue.add(i);
            }
        }

        var result = new int[numCourses];
        var count = 0;
        while (!queue.isEmpty()) {
            var node = queue.remove();
            result[numCourses - count - 1] = node;
            for (var conn : adjList[node]) {
                indegree[conn] -= 1;
                if (indegr)
            }
        }
        return new int[0];
    }
}
