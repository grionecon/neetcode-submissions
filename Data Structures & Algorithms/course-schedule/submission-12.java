class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adjList = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList<Integer>();
        }
        var indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            adjList[prerequisites[i][0]].add(prerequisites[i][1]);
            indegree[prerequisites[i][1]] += 1;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        var count = 0;
        while (!queue.isEmpty()) {
            var curr = queue.remove();
            count += 1;
            for (int i = 0; i < adjList[curr].size(); i++) {
                Integer conn = adjList[curr].get(i);
                indegree[conn] -= 1;
                if (indegree[conn] == 0) {
                    queue.add(conn);
                }
            }

        }
        return count == numCourses;
    }
}
