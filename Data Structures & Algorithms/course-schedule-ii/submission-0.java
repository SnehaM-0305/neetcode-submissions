class Solution {
    public int[] findOrder(int num, int[][] p) {
        int len = num;
        List<Integer> res = new ArrayList<>(); // result
        int[] indegree = new int[num]; // indgeree
        Queue<Integer> q = new LinkedList<>();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] n : p) {
            int source = n[1];
            int neb = n[0];

            graph.get(source).add(neb);
            indegree[neb]++;
        }

        for (int i = 0; i < num; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.poll();
            res.add(curr);

            for (int nebb : graph.get(curr)) {
                indegree[nebb]--;

                if (indegree[nebb] == 0) {
                    q.add(nebb);
                }
            }
        }

        if(res.size()!=num){ //invalid result 
        return new int[0] ; 

        }
int[] ress = new int[num] ; 
        for(int i = 0 ; i<num ; i++){
            ress[i] = res.get(i) ; 


        }

        return ress ; 
    }
}
