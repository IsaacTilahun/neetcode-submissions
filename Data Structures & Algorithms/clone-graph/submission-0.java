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

    private HashMap<Node, Node> nodeMap;

    /**
    We have a HashMap that just tracks the nodes with their copied node counterpart.
    The idea is that in a DFS format starting from our original node that is passed in,
    we will create copies and add neighbors as needed.

    Time Complexity: O(V + E), just the DFS runtime
    Space Complexity: O(V + E), that's what we output
    */

    public Node cloneGraph(Node node) {
        
        // In case we have the 0-node case
        if (node == null) {
            return null;
        }

        nodeMap = new HashMap<>();

        dfs(node);

        return (nodeMap.get(node));

    }

    private Node dfs(Node node) {

        if (nodeMap.containsKey(node)) {
            return nodeMap.get(node);
        }

        Node newNode = new Node(node.val);
        
        nodeMap.put(node, newNode);

        for (Node nei: node.neighbors) {
            newNode.neighbors.add(dfs(nei));
        }

        return newNode;

    }
}