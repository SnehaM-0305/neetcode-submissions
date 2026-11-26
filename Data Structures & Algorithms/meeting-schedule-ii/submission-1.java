
class Solution {
    public int minMeetingRooms(List<Interval> intervals) {

        if (intervals.isEmpty()) return 0;

        // Sort by start time
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < intervals.size(); i++) {

            // Check if any room is available
            if (!pq.isEmpty() && intervals.get(i).start >= pq.peek()) {
                pq.poll();
            }

            // Add current meeting's end time
            pq.offer(intervals.get(i).end);
        }

        return pq.size();
    }
}
