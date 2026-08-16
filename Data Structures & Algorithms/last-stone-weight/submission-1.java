class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a); 

        for(int num :stones){
            maxHeap.add(num) ; 
        }

        while(maxHeap.size()>1){
            int a = maxHeap.poll() ; 
            int b = maxHeap.poll() ; 

            if(a==b){
                continue  ; 
            }
            else{
                int c = Math.abs(a-b) ; 
                maxHeap.add(c) ; 
            }
        }
        if(maxHeap.size()==0){
            return 0;
        }
        return maxHeap.poll() ; 
    }
}
