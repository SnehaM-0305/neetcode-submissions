class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 1;
        int n = intervals.length ; 

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            // overlap
            if (intervals[i][0] < prevEnd) {
                continue ; 
            }

            // no overlap
            else{
                count++ ; 
                prevEnd = intervals[i][1] ; 
            }
        }
        return n-count;
    }
}
