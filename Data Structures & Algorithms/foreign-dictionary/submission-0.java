class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> adjList = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        for (var word : words) {
            for (Character c : word.toCharArray()) {
                if (!indegree.containsKey(c)) {
                    adjList.put(c, new HashSet<>());
                    indegree.put(c, 0);
                }
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            var w1 = words[i];
            var w2 = words[i + 1];
            var minLength = Integer.min(w1.length(), w2.length());
            if (w1.length() > w2.length()) {
                var chars1 = w1.toCharArray();
                var chars2 = w2.toCharArray();
                boolean isSubstring = false;
                int j = 0;
                for (; j < minLength; j++) {
                    if (chars1[j] != chars2[j]) {
                        break;
                    }
                }
                if (j == minLength) {
                    return "";
                }
            }
            var chars1 = w1.toCharArray();
            var chars2 = w2.toCharArray();
            int j = 0;
            for (; j < minLength; j++) {
                if (chars1[j] != chars2[j]) {
                    break;
                }
            }
            if (j == minLength) {
                continue;
            }
            adjList.get(chars1[j]).add(chars2[j]);
            indegree.put(chars2[j], indegree.get(chars2[j]) + 1);
        }
        var resultArr = new char[indegree.size()];
        var queue = new LinkedList<Character>();
        for (var key: indegree.keySet()) {
            if (indegree.get(key) == 0) {
                queue.add(key);
            }
        }
        int i = 0;
        while (!queue.isEmpty()) {
            var c = queue.remove();
            resultArr[i] = c;
            i++;
            indegree.put(c, -1000);
            for (var conn: adjList.get(c)) {
                var connIndegree = indegree.get(conn) - 1;
                if (connIndegree == 0) {
                    queue.add(conn);
                }
                indegree.put(conn, connIndegree);
            }
        }
        var sb = new StringBuilder();
        return new String(resultArr);
    }
}
