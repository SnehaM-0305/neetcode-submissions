class Solution {
    public void solve(char[][] board) {
        int row = board.length ; 
        int col = board[0].length ; 

        for(int i = 0 ; i<row ; i++){
            dfs(i , 0 , board) ; 
            dfs(i,col-1 , board  );
        }

        for(int j = 0 ; j<col ; j++){
            dfs(0,j,board) ; 
            dfs(row-1 , j , board) ; 
        }

        for(int i = 0 ; i <row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }

                else if(board[i][j]=='O'){
                board[i][j]='X';}
            }
        }

       

       





    }

    private void dfs(int r , int c , char[][] board){
        //safe 

        if(r<0||r>=board.length ||c<0||c>=board[0].length){
            return ; 
        }

        if(board[r][c]!='O'){
            return ; 
        }

        board[r][c]='#' ; 

        //visit all directions 
        dfs(r+1 , c , board) ; 
        dfs(r-1,c,board) ; 
        dfs(r,c+1 , board) ; 
        dfs(r,c-1,board);

    }
}
