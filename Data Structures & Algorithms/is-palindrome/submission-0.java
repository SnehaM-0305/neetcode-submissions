class Solution {
    public boolean isPalindrome(String s) {
        
        String cleaned = "";

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                cleaned += Character.toLowerCase(ch);
            }
        }
int n = cleaned.length() ;
        for(int i = 0 ; i<n/2 ; i++)
        {
            if(cleaned.charAt(i)!=cleaned.charAt(n-i-1)){
                return false ; 
            }
        }
        return true ; 
    }
}
