class Solution {
    private int[] parent ; 
    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length ; 
        parent = new int[n] ; 
        for(int i = 0 ; i<n ; i++){
            parent[i]=i ; 
        }

        for(int i = 0 ; ;i++){
            int rootA = find(edges[i][0]-1) ; 
            int rootB = find(edges[i][1]-1) ; 

            if(rootA==rootB){
                //creates cycle
                return edges[i] ; 
            }

            parent[rootA] = rootB ; 
        }
        
    }

    public int find(int x){

        if(parent[x]!=x){
            parent[x] = find(parent[x]) ; 
        }
        return parent[x] ; 

    }
}
