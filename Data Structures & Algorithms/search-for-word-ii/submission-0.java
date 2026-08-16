class Solution {

    class TrieNode{
        TrieNode[] children = new TrieNode[26] ; 
        String word = null;

    }
    TrieNode root = new TrieNode();
    public List<String> findWords(char[][] board, String[] words) {
        
        //building the trie node for the words 
        for(String word:words){
            insert(word);
        }

        List<String> result = new ArrayList<>() ; 

        for(int i = 0;i<board.length ; i++){
            for(int j=0;j<board[0].length;j++){
                dfs(board,i,j,root,result);
            }
        }

        return result;
    }

    public void insert(String word){
        TrieNode curr = root ; 

        for(char ch : word.toCharArray()){
            int idx = ch-'a';
            if(curr.children[idx]==null){
                curr.children[idx] = new TrieNode();
            }

            curr = curr.children[idx];
        }
        curr.word = word ; 
    }

    public void dfs(char[][] board , int r,int c,TrieNode node,List<String> result){

        if(r<0 ||r>=board.length||c<0||c>=board[0].length){
            return;
        }

        if(board[r][c]=='#'){
            return;
        }

        char ch = board[r][c];

        if(node.children[ch-'a']==null){
            return;
        }

        TrieNode next = node.children[ch-'a'];

        if(next.word!=null){
            result.add(next.word);

            next.word = null;
        }

        board[r][c]='#';

        dfs(board,r-1,c,next,result);
        dfs(board,r+1,c,next,result);
        dfs(board,r,c-1,next,result);
        dfs(board,r,c+1,next,result);

        board[r][c]=ch;

    }
}
