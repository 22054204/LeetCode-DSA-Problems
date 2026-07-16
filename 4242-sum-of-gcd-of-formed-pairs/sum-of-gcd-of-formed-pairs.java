class Solution {
    public long gcdSum(int[] nums) {
        long[] prefixGcd = new long[nums.length];
        long curr_mxi = nums[0];
        prefixGcd[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            curr_mxi = Math.max(curr_mxi, nums[i]);
            prefixGcd[i] = gcd(nums[i], curr_mxi);
        }
        Arrays.sort(prefixGcd);
        long sum = 0;
        int i=0;
        int j=prefixGcd.length-1;
        while(i<j){
            sum+=gcd(prefixGcd[i++], prefixGcd[j--]);
        }
        return sum;
    }
    private static long gcd(long a, long b){
        return (b==0)?a:gcd(b,a%b);
    }
}