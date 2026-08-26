class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length ; 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]) ; 
        boolean[][] vis = new boolean[n][n];

        int time =0 ; 
        pq.add(new int[]{grid[0][0] , 0 ,0}) ; 

           int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while(!pq.isEmpty()){

            int [] curr = pq.poll() ; 
            int t = curr[0] ; 
            int r = curr[1] ; 
            int c = curr[2] ; 

            if(vis[r][c]){
                continue ; 
            }

            vis[r][c]=true ;
            time = Math.max(time , t) ; 

               if (r == n - 1 && c == n - 1) {
                return time;
            }

            for (int[] dir : directions) {

                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < n &&
                    !vis[nr][nc]) {

                    pq.offer(new int[]{
                        grid[nr][nc],
                        nr,
                        nc
                    });
                }
            }
        }

        return -1;

        }



    }

