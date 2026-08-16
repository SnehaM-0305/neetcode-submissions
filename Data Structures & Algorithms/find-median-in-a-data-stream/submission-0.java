class MedianFinder {

private PriorityQueue<Integer> minHeap ; 
private PriorityQueue<Integer> maxHeap ; 
    public MedianFinder() {
        minHeap = new PriorityQueue<>() ; 
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        //adding to approproate heap 
        if(maxHeap.isEmpty()|| num<=maxHeap.peek()){
            maxHeap.add(num) ; 
        }
        else{
            minHeap.add(num) ; 
        }

        //correct the size 
        if(maxHeap.size()>minHeap.size()+1){
            minHeap.add(maxHeap.poll())  ; 
        }
        else if(minHeap.size()> maxHeap.size()+1){
            maxHeap.add(minHeap.poll()) ; 
        }
    }
    
    public double findMedian() {
        if(minHeap.size()>maxHeap.size()){
            return minHeap.peek() ; 
        }
        else if(maxHeap.size()>minHeap.size()){
            return maxHeap.peek() ; 
        }
        else{
            return (minHeap.peek() + maxHeap.peek())/2.0 ; 
        }
    }
}
