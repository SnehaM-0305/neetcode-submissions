class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // n = number of nodes

        // k=start node

        // graph creation
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] nebb : times) {
            int source = nebb[0] - 1;
            int dest = nebb[1] - 1;
            int wt = nebb[2];

            // making it zero indexed
            graph.get(source).add(new int[] {dest, wt});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k - 1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] {k - 1, dist[k - 1]});

        while (!pq.isEmpty()) {
            // get the node with least distance
            int[] node = pq.poll();
            int source = node[0];
            int distt = node[1];
            if (distt <= dist[source]) {
                dist[source] = distt;
            }

            // get the Neighbors
            for (int[] nei : graph.get(source)) {
                // calucate there distance
                int newdistance = distt + nei[1];
                if (distt > dist[source]) {
                    continue;
                }

                // relaxation step
                if (newdistance <dist[nei[0]]) {
                    dist[nei[0]] = newdistance;
                    pq.add(new int[] {nei[0], dist[nei[0]]});
                }
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            result = Math.max(result, dist[i]);
        }
        return result;
    }
}
