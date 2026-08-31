class Solution {
    public int countSubstrings(String s) {
        int count = 0 ; 
         int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int start = 0;
        int maxLen = 1;

        for (int len = 1; len <= n; len++) {

            for (int i = 0; i + len <= n; i++) {

                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j) &&
                    (len <= 2 || dp[i + 1][j - 1])) {
count++;
                    dp[i][j] = true;

                    if (len > maxLen) {
                        start = i;
                        maxLen = len;
                    }
                }
            }
        }

        return count;
    }
}
