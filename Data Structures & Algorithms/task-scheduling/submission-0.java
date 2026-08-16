class Solution {
    static class Tasks {
        int count ; 
        int nextSlot ; 

        Tasks(int count , int nextSlot){
            this.count = count ; 
            this.nextSlot = nextSlot ; 
        }
    }
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int [26] ; 

        for(char c:tasks){
            freq[c-'A']++ ; 
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()) ; 

        for(int f :freq){
            if(f>0){
                pq.add(f) ; 
            }
        }

        int time = 0 ; 
        Queue<Tasks> waitq = new LinkedList<>() ; 

        while(!pq.isEmpty() || !waitq.isEmpty()){

            //task ready to move back 
            while(!waitq.isEmpty() && waitq.peek().nextSlot<=time){
                pq.add(waitq.poll().count) ; 
            }

            //perform task 

            if(!pq.isEmpty()){
                int count = pq.poll() ; 
                count-- ; 
                if(count>0){
                    waitq.add(new Tasks(count , time+n+1)) ; 
                }
            }

            time++ ; 
        }
          return time ; 
    }

  
}
