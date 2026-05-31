import java.math.*;
class Solution {
    public int numSteps(String s) {
        BigInteger num = new BigInteger(s, 2);
        return helper(num);
    }
    private static int helper(BigInteger num){
        int count = 0;
        while(num.compareTo(BigInteger.ONE) > 0){
            if(num.mod(BigInteger.TWO).equals(BigInteger.ZERO)){
                num = num.divide(BigInteger.TWO);
            }else{
                num = num.add(BigInteger.ONE);
            }
            count++;
        }
        return count;
    }
}