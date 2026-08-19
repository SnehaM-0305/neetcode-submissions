class Solution {
    public void islandsAndTreasure(int[][] grid) {
        //bfs ( multisource) 

        int row = grid.length ; 
        int col = grid[0].length ; 

        Queue<int[]> q = new LinkedList<>() ; 

        for (int i =0 ; i <row ; i++){
            for(int j=0 ; j<col ; j++){
                if(grid[i][j]==0){
                    q.add(new int[]{i,j});
                }
            }
        }

//down , up , right , left
        int dir[][] = {{1,0} , {-1,0} , {0,1},{0,-1}} ; 

        while(!q.isEmpty()){
           int[] curr = q.poll() ; 

           int r = curr[0] ; 
           int c = curr[1] ; 

           for(int[] d :dir){
            int nr = d[0]+r ; 
            int nc = d[1]+c ; 

            //check if safe 

            if(nr<0 ||nr>=row ||nc<0||nc>=col){
                continue ; 
            }
            if(grid[nr][nc]!=Integer.MAX_VALUE){
                continue ; 
            }

            grid[nr][nc] = grid[r][c]+1 ; 

            q.add(new int[]{nr,nc});
           }


        }

    }
}
