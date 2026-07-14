import java.math.*;
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
    public static int gcd(int num1, int num2){
        BigInteger b1 = BigInteger.valueOf(num1);
        BigInteger b2 = BigInteger.valueOf(num2);

        // Use built-in gcd method
        int gcd = b1.gcd(b2).intValue();
        return gcd;
    }
}