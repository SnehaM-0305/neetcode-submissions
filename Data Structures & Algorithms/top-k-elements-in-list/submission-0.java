class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freq = new HashMap<>();

        // Count frequency
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Min heap based on frequency
        PriorityQueue<Integer> minHeap =
            new PriorityQueue<>((a, b) -> freq.get(a) - freq.get(b));

        // Keep only top k frequent elements
        for (int key : freq.keySet()) {

            minHeap.offer(key);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Store answer
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = minHeap.poll();
        }

        return ans;
    }
}