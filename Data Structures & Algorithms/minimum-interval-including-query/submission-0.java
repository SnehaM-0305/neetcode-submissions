
class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Store query and its original index
        int[][] sortedQueries = new int[queries.length][2];

        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(sortedQueries, (a, b) ->
            Integer.compare(a[0], b[0]));

        // Min Heap: {interval length, right endpoint}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int[] result = new int[queries.length];

        int i = 0;

        for (int[] q : sortedQueries) {

            int query = q[0];
            int index = q[1];

            // Add intervals starting before or at query
            while (i < intervals.length && intervals[i][0] <= query) {

                int length = intervals[i][1] - intervals[i][0] + 1;
                int right = intervals[i][1];

                pq.offer(new int[]{length, right});

                i++;
            }

            // Remove expired intervals
            while (!pq.isEmpty() && pq.peek()[1] < query) {
                pq.poll();
            }

            // Get shortest valid interval
            if (!pq.isEmpty()) {
                result[index] = pq.peek()[0];
            } else {
                result[index] = -1;
            }
        }

        return result;
    }
}
