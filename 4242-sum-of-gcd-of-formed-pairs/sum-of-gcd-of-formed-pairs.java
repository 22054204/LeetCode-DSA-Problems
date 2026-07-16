class Solution {
    public long gcdSum(int[] nums) {
        long[] prefixGcd = new long[nums.length];
        long[] mxi = new long[nums.length];
        mxi[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            mxi[i] = Math.max(nums[i], mxi[i-1]);
        }
        prefixGcd[0] = mxi[0];
        for(int i=1;i<nums.length;i++){
            prefixGcd[i] = gcd(nums[i], mxi[i]);
        }
        Arrays.sort(prefixGcd);
        long sum = 0;
        int i=0;
        int j=prefixGcd.length-1;
        while(i<j){
            sum+=gcd(prefixGcd[i], prefixGcd[j]);
            i++;
            j--;
        }
        return sum;
    }
    private static long gcd(long a, long b){
        return (b==0)?a:gcd(b,a%b);
    }
}