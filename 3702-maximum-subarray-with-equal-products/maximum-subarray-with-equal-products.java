class Solution {
    public int maxLength(int[] nums) {
        int maxLen = 1;
        int i=0;
        while(i<nums.length){
            int j=i;
            while(j<nums.length){
                int prod = product(nums, i, j);
                int lcm = lcm(nums, i, j);
                int gcd = gcd(nums, i, j);
                
                // System.out.println("i->" + i + " j->" + j);
                // System.out.println("prod -" + prod);
                // System.out.println("lcm -" + lcm);
                // System.out.println("gcd - " + gcd);

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
        if (a==0 || b==0) {
            return 0;
        }
        return Math.abs(a/findGcd(a, b) * b);
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
        if(a==0) return b;
        return findGcd(b%a, a);
    }
}