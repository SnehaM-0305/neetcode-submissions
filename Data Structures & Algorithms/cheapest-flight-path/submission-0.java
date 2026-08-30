class Solution {
    public int findCheapestPrice(int n, int[][] flights,
                                 int src, int dst, int k) {

        // adjacency list
        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];

            graph[from].add(new int[]{to, price});
        }

        // {airport, cost, stops}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[1], b[1])
        );

        pq.offer(new int[]{src, 0, 0});

        // minimum cost to reach airport with a certain number of stops
        int[][] dist = new int[n][k + 2];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dist[src][0] = 0;

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int airport = current[0];
            int cost = current[1];
            int stops = current[2];

            // Destination reached
            if (airport == dst) {
                return cost;
            }

            // Can't take more flights
            if (stops == k + 1) {
                continue;
            }

            for (int[] edge : graph[airport]) {

                int nextAirport = edge[0];
                int price = edge[1];

                int newCost = cost + price;
                int newStops = stops + 1;

                if (newCost < dist[nextAirport][newStops]) {

                    dist[nextAirport][newStops] = newCost;

                    pq.offer(new int[]{
                        nextAirport,
                        newCost,
                        newStops
                    });
                }
            }
        }

        return -1;
    }
}