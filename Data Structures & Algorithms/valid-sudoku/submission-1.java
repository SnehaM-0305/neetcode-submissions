class Solution {
    public boolean isValidSudoku(char[][] board) {
       for(int i =0 ; i<board.length ; i++){ //row
        for(int j =0 ; j<board[0].length ; j++){ //col
            int startrow = (i/3)*3 ; 
            int startcol = (j/3)*3;
      if(board[i][j]!='.'){
//check in row 
for(int k =0 ; k<9 ; k++)
{
    if(k!=j && board[i][j]==board[i][k]){
        return false;
    }
}
            //check in col
            for(int k =0 ; k<9 ; k++)
{
    if(k!=i && board[i][j]==board[k][j]){
        return false;
    }
}
            

            //check in box
            for(int ii=startrow ; ii<startrow+3 ; ii++){
                for(int jj =startcol ; jj<startcol+3 ; jj++ )
                {
                    if (ii == i && jj == j) continue;
                    if(board[i][j]==board[ii][jj]){
                        return false ;
                    }
                }
            }

      }
            
        }
       } 
       return true;
    }
}
