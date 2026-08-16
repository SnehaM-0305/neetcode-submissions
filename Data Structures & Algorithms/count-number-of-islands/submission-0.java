class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length ; 
        int col = grid[0].length ; 
        int count = 0 ; 

        for(int i = 0;i<row;i++){
            for(int j = 0 ; j<col ; j++){
                if(grid[i][j]=='1'){
                    count++;

                    dfs(grid,i,j);
                }
            }
        }
        return count ; 
        
    }

    private void dfs(char[][] grid , int r,int c){
        //check if it is safe or now 

        if(r<0 || r>=grid.length ||c<0 ||c>=grid[0].length){
            return;
        }
        if(grid[r][c]=='0'){
            return ; 
        }

        //mark it as visited 
        grid[r][c]='0' ; 

        //traverse in all directions 
dfs(grid,r-1,c) ; 
dfs(grid,r+1,c) ; 
dfs(grid,r,c-1);
dfs(grid,r,c+1) ; 

return;

    }
}
