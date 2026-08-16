class Solution {
    public int lengthOfLongestSubstring(String s) {
         HashMap<Character, Integer> map = new HashMap<>();

        int i = 0;
        int mx = 0;

        for (int j = 0; j < s.length(); j++) {

            char c = s.charAt(j);

            if (map.containsKey(c)) {
                i = Math.max(i, map.get(c) + 1);
            }

            map.put(c, j);

            mx = Math.max(mx, j - i + 1);
        }

        return mx;
    }
}
