class Solution {
    class Coordinates{
        int x ; 
        int y ; 
        Coordinates(int x , int y){
            this.x = x ; 
            this.y = y ; 
        }

    }
    public int[][] kClosest(int[][] points, int k) {
                PriorityQueue<Coordinates> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(
        b.x * b.x + b.y * b.y,
        a.x * a.x + a.y * a.y
    )); 

    for( int[] p:points){
        maxHeap.add(new Coordinates(p[0],p[1])) ; 
          if (maxHeap.size() > k) {
            maxHeap.poll(); 
        }
    }

    int [][] ans = new int[k][2];
    for (int i = 0; i < k; i++) {
        Coordinates c = maxHeap.poll();
        ans[i][0] = c.x;
        ans[i][1] = c.y;
    }
return ans ; 


    }
}
