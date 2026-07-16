class Solution {
    public long gcdSum(int[] nums) {
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
    private static int gcd(int a, int b){
        return (b==0)?a:gcd(b,a%b);
    }
}