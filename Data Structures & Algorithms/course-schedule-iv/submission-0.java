class Solution {
    List<Integer>[] adjList;
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        adjList = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList();
        }
        var indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            adjList[preprequisites[i][0]].add(preprequisites[i][1]);
            indegree[preprequisites[i][1]] += 1;
        }
        

    }
}