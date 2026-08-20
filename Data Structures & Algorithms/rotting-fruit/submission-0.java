class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length ; 
        int col = grid[0].length ; 

        Queue<int[]> q = new LinkedList<>() ; 

        int fresh = 0 ; 

        int minutes = 0; 
         for(int i = 0 ; i<row;i++){
            for(int j = 0;j<col ; j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }

                if(grid[i][j]==1){
                    fresh++;
                }
            }
         }

         int [][] dir ={{1,0},{-1,0},{0,1},{0,-1}};

         while(!q.isEmpty()&&fresh>0){
int size = q.size() ; 

for(int i = 0;i<size ; i++)
{

    int [] curr = q.poll() ; 

    int r = curr[0] ; 
    int c = curr[1] ; 

    for(int[] d: dir){

        int nr = r+d[0] ; 
        int nc = c+d[1] ; 

        if(nr>=0 && nr<row && nc>=0 &&nc<col && grid[nr][nc]==1){
            grid[nr][nc]=2 ;
            fresh--;
            q.add(new int[]{nr,nc}); 
        }
    }

}
minutes++ ; 
         }

         return fresh==0?minutes:-1;
    }
}
