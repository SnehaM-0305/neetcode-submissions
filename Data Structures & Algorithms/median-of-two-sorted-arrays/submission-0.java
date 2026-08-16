class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       

        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1) ; 
        }

        int A = nums1.length ; 
        int B = nums2.length ; 

        int left = 0 ; 
        int right = A ; 

        int half = (A+B+1)/2 ;  //finding how many element we need on both sides 

        while(left<=right){
            int i = (left+right)/2  ; 
            int j = half-i ; 

            int Aleft  = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int Aright = (i == A) ? Integer.MAX_VALUE : nums1[i];

            int Bleft  = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int Bright = (j == B) ? Integer.MAX_VALUE : nums2[j];

            if (Aleft <= Bright && Bleft <= Aright) {
                if ((A + B) % 2 == 1) {
                    return Math.max(Aleft, Bleft);
                } else {
                    return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
                }
            }
         
            else if (Aleft > Bright) {
                right = i - 1;
            } else {
                left = i + 1;
            }

        }

        throw new IllegalArgumentException("Input arrays are not sorted.");


    }
}
