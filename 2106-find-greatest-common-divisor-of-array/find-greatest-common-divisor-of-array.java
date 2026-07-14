class Solution {
    public int findGCD(int[] nums) {
        int min = 1001;
        for(int i=0;i<nums.length;i++){
            min = Math.min(nums[i], min);
        }
        int max = 0;
        for(int i=0;i<nums.length;i++){
            max = Math.max(nums[i], max);
        }
        int result = gcd(min, max);
        return result;
    }
    public static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
}