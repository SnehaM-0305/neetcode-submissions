
class CountSquares {

    Map<Integer, Map<Integer, Integer>> map;

    public CountSquares() {
        map = new HashMap<>();
    }

    public void add(int[] point) {

        int x = point[0];
        int y = point[1];

        map.putIfAbsent(x, new HashMap<>());

        Map<Integer, Integer> yMap = map.get(x);

        yMap.put(y, yMap.getOrDefault(y, 0) + 1);
    }

    public int count(int[] point) {

        int x = point[0];
        int y = point[1];

        int ans = 0;

        for (int x2 : map.keySet()) {

            if (x2 == x) continue;

            int d = Math.abs(x2 - x);

            // Point on the same horizontal line
            int freq1 = map.get(x2).getOrDefault(y, 0);

            if (freq1 == 0) continue;

            // Square above
            int freq2 = map.getOrDefault(x, new HashMap<>())
                           .getOrDefault(y + d, 0);

            int freq3 = map.get(x2).getOrDefault(y + d, 0);

            ans += freq1 * freq2 * freq3;

            // Square below
            freq2 = map.getOrDefault(x, new HashMap<>())
                       .getOrDefault(y - d, 0);

            freq3 = map.get(x2).getOrDefault(y - d, 0);

            ans += freq1 * freq2 * freq3;
        }

        return ans;
    }
}
