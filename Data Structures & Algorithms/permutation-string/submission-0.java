class Solution {
    public boolean compare(int[] freq , int[] window)
    {
        //match /compare the freq 
            for(int k = 0 ; k<26 ; k++){
                if(freq[k]!=window[k]){
                    return false ; 
                }

            }
            return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26] ; 
        int[] window = new int[26] ; 
        int n = s1.length() ; 
        int m = s2.length() ; 
        if(n>m){
            return false ; 
        }
        for(int i = 0 ; i<n ; i++)
        {
            freq[s1.charAt(i)-'a']++;
        }
        int left = 0;

        for (int right = 0; right < m; right++) {

            // add current char to window
            window[s2.charAt(right) - 'a']++;

            // shrink window if size > n
            if (right - left + 1 > n) {
                window[s2.charAt(left) - 'a']--;
                left++;
            }

            // check only when window size matches
            if (right - left + 1 == n && compare(freq, window)) {
                return true;
            }
        }

        return false;
    }
}
