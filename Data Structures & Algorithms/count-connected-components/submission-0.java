class Solution {
    public void dfs(int node, boolean[] vis, List<List<Integer>> graph) {
        vis[node] = true;

        // visit its nebb

        for (int nebb : graph.get(node)) {
            if (!vis[nebb]) {
                dfs(nebb, vis, graph);
            }
        }

        return;
    }
    public int countComponents(int n, int[][] edges) {
        int count = 0;
        boolean[] visited = new boolean[n];
        // create graph
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

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, visited, graph);
            }
        }
        return count;
    }
}
