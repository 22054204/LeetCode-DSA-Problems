class Solution {
    public int maxLength(int[] nums) {
        int prod;
        int lcm;
        int gcd;
        int maxLen = 1;
        int i=0;
        int j;
        while(i<nums.length){
            j=i;
            while(j<nums.length){
                prod = product(nums, i, j);
                lcm = lcm(nums, i, j);
                gcd = gcd(nums, i, j);

                if(prod == lcm*gcd){
                    maxLen = Math.max(maxLen, j-i+1);
                }

                j++;
            }
            i++;
        }
        return maxLen;
    }
    public int lcm(int[] nums, int st, int end){
        int lcm = nums[st];
        for(int i=st+1;i<=end;i++){
            lcm = findLCM(nums[i], lcm);
        }
        return lcm;
    }
    public int findLCM(int a, int b) {
        return a==0||b==0?0:Math.abs(a/findGcd(a,b)*b);
    }
    public int product(int[] nums, int st, int end){
        int prod = 1;
        for(int i=st;i<=end;i++){
            prod*=nums[i];
        }
        return prod;
    }
    public int gcd(int[] nums, int st, int end){
        int gcd = st;
        for(int i=st;i<=end;i++){
            gcd = findGcd(nums[i], gcd);
        }
        return gcd;
    }
    public int findGcd(int a, int b){
        return a==0?b:findGcd(b%a, a);
    }
}