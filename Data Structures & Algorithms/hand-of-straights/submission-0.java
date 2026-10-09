
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        // Frequency map: value -> how many copies of this value remain unused
        Map<Integer, Integer> count = new HashMap<>();
        for (int card : hand) {
            count.put(card, count.getOrDefault(card, 0) + 1);
        }

        // Min-heap of distinct values, so we can always grab the smallest remaining one
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(count.keySet());

        while (!minHeap.isEmpty()) {
            int smallest = minHeap.peek();

            // This value might already be used up by an earlier group — skip it
            if (count.get(smallest) == 0) {
                minHeap.poll();
                continue;
            }

            // Try to build one full group: smallest, smallest+1, ..., smallest+groupSize-1
            for (int i = 0; i < groupSize; i++) {
                int need = smallest + i;
                Integer c = count.get(need);
                if (c == null || c == 0) {
                    return false; // missing a required consecutive value — impossible
                }
                count.put(need, c - 1);
            }
        }

        return true;
    }
}