class Solution {
    public int characterReplacement(String s, int k) {
        int [] count = new int[26] ; 
        int left = 0 ; 
        int maxfreq = 0 ; 
        int result = 0 ; 
        for(int right = 0 ; right<s.length() ; right++){
            count[s.charAt(right)-'A']++;

            maxfreq = Math.max(maxfreq , count[s.charAt(right)-'A']) ; 

            //see if gets out of bound/window
            while((right-left+1)-maxfreq > k){
                count[s.charAt(left)-'A']--;
                left++;

            }
            result = Math.max(result,right-left+1);
        }
        return result ; 
    }
}
