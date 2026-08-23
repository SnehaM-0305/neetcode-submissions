class Solution {
    public boolean dfs(int node, boolean[] vis, List<List<Integer>> edges, int parent) {
        vis[node] = true;

        // check for neighbours

        for (int nebb : edges.get(node)) {
            // if the nebb is not visited

            if (!vis[nebb]) {
                if (dfs(nebb, vis, edges, node)) {
                    return true;
                }
            }

            // if visited but parent

            else if (vis[nebb] && nebb != parent) {
                return true;
            }
        }
        return false;
    }
    public boolean validTree(int n, int[][] edges) {
        // a graph is a tree-> have no cycle in it

        if (edges.length != n - 1) {
            return false;
        }
        boolean[] visited = new boolean[n];
        // create graph in adjacent

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int source = edge[0];
            int dest = edge[1];

            graph.get(source).add(dest);
            graph.get(dest).add(source);
        }

        // perfomr cycle detection in graph

        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i]) {
                if (dfs(i, visited, graph, -1)) {
                    return false;
                }
            }
        }
        return true;
    }
}
