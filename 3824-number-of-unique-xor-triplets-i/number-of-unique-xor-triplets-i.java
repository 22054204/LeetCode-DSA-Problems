class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n=nums.length;
        if(n==1) return 1;
        if(n==2) return 2;
        int bits=32-Integer.numberOfLeadingZeros(n);
        //return (int)Math.pow(2, bits); 

        // instead of using inbuild power function ... precompute powers of 2 up to the maximum.
        int[] pow={1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,131072};
        return pow[bits];
    }
}