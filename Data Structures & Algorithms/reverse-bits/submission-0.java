
class Solution {
    public int reverseBits(int n) {

        int ans = 0;

        for (int i = 0; i < 32; i++) {

            int bit = n & 1;       // Get last bit

            ans = (ans << 1) | bit; // Add bit to answer

            n = n >>> 1;           // Remove last bit
        }

        return ans;
    }
}
