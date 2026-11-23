
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0, n = intervals.length;
        int start = newInterval[0], end = newInterval[1];

        // 1. Add all intervals that end before newInterval starts (no overlap, come first)
        while (i < n && intervals[i][1] < start) {
            result.add(intervals[i]);
            i++;
        }

        // 2. Merge all intervals that overlap with newInterval
        while (i < n && intervals[i][0] <= end) {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        result.add(new int[]{start, end});

        // 3. Add remaining intervals that start after newInterval ends
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}