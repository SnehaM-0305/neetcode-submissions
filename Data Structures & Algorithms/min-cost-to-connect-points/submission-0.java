class Solution {

    public int minCostConnectPoints(int[][] points) {

        int n = points.length;

        List<int[]> edges = new ArrayList<>();

        // Create all possible edges
        for (int i = 0; i < n - 1; i++) {

            for (int j = i + 1; j < n; j++) {

                int[] p1 = points[i];
                int[] p2 = points[j];

                int dist = Math.abs(p2[0] - p1[0])
                         + Math.abs(p2[1] - p1[1]);

                // {weight, source, destination}
                edges.add(new int[]{dist, i, j});
            }
        }

        // Sort edges by weight
        edges.sort((a, b) -> Integer.compare(a[0], b[0]));

        DSU dsu = new DSU(n);

        int cost = 0;
        int count = 0;

        // Kruskal
        for (int[] edge : edges) {

            int weight = edge[0];
            int src = edge[1];
            int dest = edge[2];

            // If they are not already connected
            if (dsu.find(src) != dsu.find(dest)) {

                dsu.union(src, dest);

                cost += weight;
                count++;

                if (count == n - 1) {
                    break;
                }
            }
        }

        return cost;
    }
}
// Disjoint set data structure
class DSU {
    private int[] parent, rank;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    public void union(int x, int y) {
        int s1 = find(x);
        int s2 = find(y);
        if (s1 != s2) {
            if (rank[s1] < rank[s2]) {
                parent[s1] = s2;
            } else if (rank[s1] > rank[s2]) {
                parent[s2] = s1;
            } else {
                parent[s2] = s1;
                rank[s1]++;
            }
        }
    }
}