class Solution {
    Map<String, List<Pair<String, Double>>> adj = new HashMap<>();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        adj = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            adj.putIfAbsent(a, new ArrayList<>());
            adj.get(a).add(new Pair<>(b, values[i]));
            
            adj.putIfAbsent(b, new ArrayList<>());
            adj.get(b).add(new Pair<>(a, 1.0 / values[i]));
        }
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            var item = queries.get(i);
            String start = item.get(0);
            String end = item.get(1);
            results[i] = dfs(start, end, new HashSet<>());
        }
        return results;
    }
    double dfs(String start, String end, Set<String> visited) {
        if (!adj.containsKey(start) || !adj.containsKey(end)) {
            return -1;
        }
        if (start.equals(end)) {
            return 1.0;
        }
        visited.add(start);
        List<Pair<String, Double>> connections = adj.get(start);
        for (int i = 0; i < connections.size(); i++) {
            Pair<String, Double> nextPair = connections.get(i);
            String next = nextPair.getKey();
            if (!visited.contains(next)) {
                double result = dfs(next, end, visited);
                if (result != -1.0) {
                    return nextPair.getValue() * result;
                }
            }
        }
        return - 1;
    }
}