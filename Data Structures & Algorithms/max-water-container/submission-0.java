class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length ; 
        int maxcap = 0 ; 
        int i = 0 ; 
        int j = n-1 ; 
        while(i<j)
        {
            int height = Math.min(heights[i],heights[j]);
            int cap = height*(j-i) ; 
            maxcap = Math.max(maxcap , cap) ; 

            if(heights[i]<=heights[j]){
                i++ ;
            }
            else{
                j--;
            }
        }
        return maxcap;
    }
}
