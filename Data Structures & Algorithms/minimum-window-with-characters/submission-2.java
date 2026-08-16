class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (n < m) {
            return "";
        }

        // putting all values in need from t to check
        HashMap<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < m; i++) {
            char ch = t.charAt(i);
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int formed = 0;
        int required = need.size();
        int start = 0;
        int minLen = Integer.MAX_VALUE;

        while (right < n) {
            char ch = s.charAt(right);

            // put in sliding window
            window.put(ch, window.getOrDefault(ch, 0) + 1);

            // check if the need is met
            if (need.containsKey(ch) && window.get(ch).intValue() == need.get(ch).intValue()) {
                formed++;
            }

            // shrinking thr window ->only start shrinking when the need is met
            while (left <= right && formed == required) {
                // update window size
                int windowlen = right - left + 1;
                if (windowlen < minLen) {
                    minLen = windowlen;
                    // update the start
                    start = left;
                }

                // shrink the window
                char leftchar = s.charAt(left);

                // Remove left character
                window.put(leftchar, window.get(leftchar) - 1);

                // check if window is valid
                if (need.containsKey(leftchar) && window.get(leftchar) < need.get(leftchar)) {
                    formed--;
                }
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
