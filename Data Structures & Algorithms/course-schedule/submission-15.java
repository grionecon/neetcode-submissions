class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList<Integer>();
        }
        //The indegree of a vertex in a directed graph is the total number of incoming edges pointing directly into that specific vertex
        var indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            adjList[prerequisites[i][0]].add(prerequisites[i][1]);
            indegree[prerequisites[i][1]] += 1;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        var visitedEdgeCount = 0;
        while (!q.isEmpty()) {
            var currEdge = q.remove();
            visitedEdgeCount += 1;
            for (var connection : adjList[currEdge]) {
                indegree[connection] -= 1;
                if (indegree[connection] == 0) {
                    q.add(connection);
                }
            }
        }
        return visitedEdgeCount == numCourses;
    }
}
