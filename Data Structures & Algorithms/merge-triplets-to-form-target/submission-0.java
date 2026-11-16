class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int n = triplets.length;
        int[] best = {0, 0, 0};
        for (int i = 0; i < n; i++) {
            // check for pisioned triplet
            if (triplets[i][0] > target[0] || triplets[i][1] > target[1]
                || triplets[i][2] > target[2]) {
                continue;
            }

            // check if it became eqaul to the triplet


            // walk and pick

            else{
                best[0] = Math.max(triplets[i][0] , best[0]) ; 
                 best[1] = Math.max(triplets[i][1],best[1]) ; 
                  best[2] = Math.max(triplets[i][2],best[2]) ; 
            }
        }

         if (best[0] == target[0] && best[1] == target[1]
                && best[2] == target[2]) {
                return true;
            }
        return false ; 
    }
}
