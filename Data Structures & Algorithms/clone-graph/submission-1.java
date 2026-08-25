/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        var clone = new Node(node.val);
        return dfs(node, clone);
    }
    Node dfs(Node node, Node clone) {
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        visited.put(node, clone);
        for (var conn : node.neighbors) {
            var newNode = new Node(conn.val);
            clone.neighbors.add(dfs(conn, newNode));
        }
        return clone;
    }
}