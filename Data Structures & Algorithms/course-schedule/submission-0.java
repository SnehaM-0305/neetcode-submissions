class Solution {
    public boolean canFinish(int num, int[][] p) {
        int length = num;
        
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[num];
        Queue<Integer> q = new LinkedList<>();
        // build graph
        for (int i = 0; i < length; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] def : p) {
            int source = def[1];
            int neigh = def[0];
            indegree[neigh]++;

            graph.get(source).add(neigh);
        }

        // apply kahn algorithm

        for(int i = 0 ; i <num ; i++){
            if(indegree[i]==0){
                q.add(i) ; 
            }
        }

        int total = 0 ; 

        while(!q.isEmpty()){
            int curr = q.poll() ; 

            total++; 

            //deduct indegree for its neighbours now 

            for(int n : graph.get(curr)){
                indegree[n]--; 

                if(indegree[n]==0){
                    q.add(n) ; 
                }
            }
        }

        if(total==num){
            return true ;
        }

        return false ; 

    }
}
