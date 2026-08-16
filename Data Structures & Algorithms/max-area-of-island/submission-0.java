class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int maxArea = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (grid[r][c] == 1) {
                    int area = dfs(grid, r, c);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c) {

        // Out of bounds or water
        if (r < 0 || r >= grid.length ||
            c < 0 || c >= grid[0].length ||
            grid[r][c] == 0) {
            return 0;
        }

        // Mark as visited
        grid[r][c] = 0;

        // Count current cell + connected land
        int area = 1;

        area += dfs(grid, r - 1, c); // up
        area += dfs(grid, r + 1, c); // down
        area += dfs(grid, r, c - 1); // left
        area += dfs(grid, r, c + 1); // right

        return area;
    }
}