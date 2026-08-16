class Solution {
    private boolean dfs(char[][] board , String word,int i , int j , int idx){
        if(idx==word.length()){
            return true ; 
        }

        //boundary conditions 
        if(i>=board.length || j>=board[0].length ||i<0 ||j<0||board[i][j]!=word.charAt(idx)){
            return false ; 
        }

        char temp = board[i][j] ; 
        //mark visited 
        board[i][j]='#' ; 

        boolean found = dfs(board,word,i+1 , j , idx+1) ||
        dfs(board , word , i-1 , j , idx+1) ||
        dfs(board , word , i , j+1 , idx+1)||
        dfs(board , word , i , j-1 , idx+1) ; 

        board[i][j]=temp ; 
        return found ; 

    }
    public boolean exist(char[][] board, String word) {
        int rows = board.length ; 
        int col = board[0].length;

        for(int i = 0; i <rows ; i++){
            for(int j = 0  ; j<col;j++){
                if(dfs(board ,word, i , j , 0)){
                    return true ; 
                }
            }
        }
        return false ; 
    }
}
