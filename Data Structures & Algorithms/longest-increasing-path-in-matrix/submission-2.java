class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int maxPath = Integer.MIN_VALUE;
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];

        int[][] cells = new int[rows * cols][3];
        int idx = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[idx++] = new int[] {i, j, matrix[i][j]};
            }
        }
        Arrays.sort(cells , (a,b)->b[2]-a[2]) ; 
        for(int [] cell :cells){
            int i = cell[0] ; 
            int j = cell[1] ; 

            dp[i][j] = 1 ; 

            //cpmpare with neigbhous 
             if (i + 1 < rows && matrix[i + 1][j] > matrix[i][j]) {
                dp[i][j] = Math.max(dp[i][j], dp[i + 1][j] + 1);
            }
            if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) {
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + 1);
            }
            if (j + 1 < cols && matrix[i][j + 1] > matrix[i][j]) {
                dp[i][j] = Math.max(dp[i][j], dp[i][j + 1] + 1);
            }
            if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) {
                dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + 1);
            }
maxPath = Math.max(maxPath, dp[i][j]);

        }

        return maxPath ; 
    }
}
