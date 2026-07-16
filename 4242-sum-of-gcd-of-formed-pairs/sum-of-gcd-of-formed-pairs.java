class Solution {
    public long gcdSum(int[] nums) {
        return Method3(nums);
    }
    private static int gcd(int a, int b){
        return (b==0)?a:gcd(b,a%b);
    }
    private long Method3(int[] nums) {
        int curr_mxi = nums[0];
        for(int i=1;i<nums.length;i++){
            curr_mxi = Math.max(curr_mxi, nums[i]);
            nums[i] = gcd(nums[i], curr_mxi);
        }
        Arrays.sort(nums);
        long sum = 0;
        int i=0;
        int j=nums.length-1;
        while(i<j){
            sum+=gcd(nums[i++], nums[j--]);
        }
        return sum;
    }
    private long Method2(int[] nums) {
        int[] prefixGcd = new int[nums.length];
        int curr_mxi = nums[0];
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
    private long Method1(int[] nums) {
        int[] prefixGcd = new int[nums.length];
        int[] mxi = new int[nums.length];
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
            sum+=gcd(prefixGcd[i++], prefixGcd[j--]);
        }
        return sum;
    }
}