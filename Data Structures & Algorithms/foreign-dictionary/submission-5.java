class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> adjList = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        for (var word : words) {
            for (var c : word.toCharArray()) {
                adjList.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        for(int i = 0; i < words.length - 1; i++) {
            var w1 = words[i];
            var w2 = words[i + 1];
            var minLength = Integer.min(w1.length(), w2.length());
            if (w1.length() > w2.length() && 
            w1.substring(0, minLength).contains(w2.substring(0, minLength))) {
                return "";
            }
            var chars1 = w1.toCharArray();
            var chars2 = w2.toCharArray();
            for (int j = 0; j < minLength; j++) {
                if (chars1[j] != chars2[j]
                    && !adjList.get(chars1[j]).contains(chars2[j])
                ) {
                    adjList.get(chars1[j]).add(chars2[j]);
                    indegree.put(chars2[j], indegree.get(chars2[j]) + 1);
                }
            }
        }
        Queue<Character> queue = new LinkedList<>();
        for (var key: indegree.keySet()) {
            if(indegree.get(key) == 0) {
                queue.add(key);
            }
        }
        var sb = new StringBuilder();
        while (!queue.isEmpty()) {
            var c = queue.remove();
            sb.append(c);
            indegree.put(c, -1);
            for (var conn : adjList.get(c)) {
                var level = indegree.get(conn) - 1;
                if (level == 0) {
                    queue.add(conn);
                }
                indegree.put(conn, level);
            }
        }
        if (sb.length() == indegree.size()) {
            return sb.toString();
        }
        return "";
    }
}
