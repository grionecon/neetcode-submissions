class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList<>();
        }
        var indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            adjList[prerequisites[i][0]].add(prerequisites[i][1]);
            indegree[prerequisites[i][1]] += 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        var result = new int[numCourses];
        var count = 0;
        while (!queue.isEmpty()) {
            var node = queue.remove();
            result[numCourses - count - 1] = node;
            count += 1;
            for (var conn : adjList[node]) {
                indegree[conn] -= 1;
                if (indegree[conn] == 0) {
                    queue.add(conn);
                }
            }
        }
        if (count != numCourses) {
            return new int[0];
        }
        return result;
    }
}
