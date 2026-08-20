class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] h) {
        //using bfs in this approach 
        //two boolean gris for tracing pacific and atlantic visit

        //two queues to store pacific and atlantic visited nodes 

        int row = h.length ; 
        int col = h[0].length ; 

        boolean [][] pacific = new boolean[row][col] ; 
        boolean [][] atlantic = new boolean[row][col] ; 
        Queue<int[]> pacq = new LinkedList<>() ; 
        Queue<int[]> atlq = new LinkedList<>() ;  

        for(int i = 0 ;i<row ; i++){
            pacq.add(new int[]{i,0}) ; 
            pacific[i][0]=true ; 
            atlq.add(new int[]{i,col-1});
            atlantic[i][col-1] = true ;
        }

        for(int i = 0 ; i<col ; i++){
            pacq.add(new int[]{0,i}) ; 
            pacific[0][i]=true ; 

            atlq.add(new int[]{row-1 , i}) ; 
            atlantic[row-1][i]=true ; 
        }

        bfs(h,pacific,pacq) ; 
        bfs(h,atlantic , atlq);

        List<List<Integer>> res  = new ArrayList<>() ; 
        for(int i = 0; i <row;i++){
            for(int j =0 ; j<col ; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }

        return res ; 
    }

    public void bfs(int[][] h , boolean [][] vis , Queue<int[]> q){
    int[][] dir = {{1,0} ,{-1,0} , {0,1},{0,-1}} ; 
    while(!q.isEmpty()){
        int[] curr = q.poll() ; 
        int r = curr[0] ; 
        int c = curr[1] ; 

        for(int []d:dir){
            int nr = r+d[0] ; 
            int nc = c+d[1] ; 

             if (nr < 0 || nr >= h.length ||
                    nc < 0 || nc >= h[0].length) {
                    continue;
                }

            
                if (vis[nr][nc]) {
                    continue;
                }

                if(h[nr][nc]>=h[r][c]){
                    vis[nr][nc] = true ; 
                    q.add(new int[]{nr,nc});
                }
        }
    }




    }
}
