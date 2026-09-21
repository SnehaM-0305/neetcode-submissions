class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[][] dp = new int[n + 1][m + 1];
        return solve(s, p, 0, 0, dp);
    }

    public boolean solve(String s, String p, int i, int j, int[][] dp) {
        if (i == s.length() && j == p.length()) {
            return true;
        }

        if (i == s.length()) {
            int k = j;
            while (k < p.length()) {
                if (k + 1 >= p.length() || p.charAt(k + 1) != '*') {
                    return false;
                }
                k += 2;
            }
            return true;
        }

        if (j == p.length()) {
            return false;
        }

        if (dp[i][j] != 0) {
            return dp[i][j] == 1;
        }

        boolean starNext = (j + 1 < p.length() && p.charAt(j + 1) == '*');
        boolean result;

        if (starNext) {
            boolean skipPair = solve(s, p, i, j + 2, dp);
            boolean usePair = false;
            if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                usePair = solve(s, p, i + 1, j, dp);
            }
            result = skipPair || usePair;
        } else if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            result = solve(s, p, i + 1, j + 1, dp);
        } else {
            result = false;
        }

        dp[i][j] = result ? 1 : -1;
        return result;
    }
}