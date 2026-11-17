class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length() ; 
        int[] lastocc = new int[26] ; 
        for(int i = 0 ; i<n ; i++){
            lastocc[s.charAt(i)-'a'] = i ; 
        }
        int start = 0 ; 
        int end = 0  ; 
        List<Integer> result = new ArrayList<>() ; 

        for(int i = 0 ; i <n ; i++){

            end = Math.max(end , lastocc[s.charAt(i)-'a']) ; 
            if(i==end){
                result.add(end-start+1) ; 
                start = end+1 ; 
            }


        }

        return result ; 
    }
}
