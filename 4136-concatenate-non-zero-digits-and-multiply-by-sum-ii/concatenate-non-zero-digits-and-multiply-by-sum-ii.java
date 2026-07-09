import java.math.*;
class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        return Optimal(s, queries);
    }

    // Optimal 
    public int[] Optimal(String s, int[][] queries) {
        int MOD = 1000000007;
        int[] prefixSum = new int[s.length()];
        prefixSum[0] = s.charAt(0) - '0';
        for(int i=1;i<s.length();i++){
            prefixSum[i] = prefixSum[i-1]+s.charAt(i)-'0';
        }
        //System.out.println("prefixSum "+Arrays.toString(prefixSum));

        int[] numberUpTo = new int[s.length()];
        numberUpTo[0] = s.charAt(0) - '0';
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='0'){
                numberUpTo[i] = numberUpTo[i-1];
            }else{
                numberUpTo[i] = (int)(((long)numberUpTo[i - 1] * 10 + (s.charAt(i) - '0')) % MOD);
            }
        }
        //System.out.println("numberUpTo "+Arrays.toString(numberUpTo));

        int[] nonZeros = new int[s.length()];
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='0') count++;
            nonZeros[i] = count;
        }
        //System.out.println("nonZeros "+Arrays.toString(nonZeros));

        int[] power10 = new int[s.length()];
        power10[0] = 1;
        for(int i=1;i<s.length();i++){
            power10[i] = (int)(10L*power10[i-1]%MOD);
        }
        //System.out.println("power10 "+Arrays.toString(power10));

        int[] result = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int a = queries[i][0];
            int b = queries[i][1];

            int k;
            if(a!=0) k = nonZeros[b]-nonZeros[a-1];
            else k = nonZeros[b];

            int num;
            if(a!=0) num = (int)((numberUpTo[b] - (((long)numberUpTo[a-1] * power10[k]) % MOD) + MOD) % MOD);
            else num = numberUpTo[b];

            int sum;
            if(a!=0) sum = prefixSum[b]-prefixSum[a-1];
            else sum = prefixSum[b];

            result[i] = (int)(((long)num * sum) % MOD);
        }
        return result;
    }

    // using BIGINTEGER - TLE
    public int[] Better(String s, int[][] queries) {
        BigInteger[] arr = new BigInteger[queries.length];
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            String dummy = s.substring(a, b+1);
            BigInteger num = new BigInteger(dummy);
            arr[i] = num;
        }
        for (int i = 0; i < ans.length; i++) {
            BigInteger num = helper2(arr[i]);
            BigInteger mod = BigInteger.valueOf(1000000007L);
            ans[i] = num.mod(mod).intValue();
        }
        return ans;
    }
    public BigInteger helper2(BigInteger n) {
        BigInteger rev = BigInteger.ZERO;
        BigInteger sum = BigInteger.ZERO;
        while (n.compareTo(BigInteger.ZERO) > 0) {
            if (n.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
                n = n.divide(BigInteger.TEN);
            } else {
                rev = rev.multiply(BigInteger.TEN).add(n.mod(BigInteger.TEN));
                sum = sum.add(rev.mod(BigInteger.TEN));
                n = n.divide(BigInteger.TEN);
            }
        }
        BigInteger revToSt = BigInteger.ZERO;
        while (rev.compareTo(BigInteger.ZERO) > 0) {
            revToSt = revToSt.multiply(BigInteger.TEN).add(rev.mod(BigInteger.TEN));
            rev = rev.divide(BigInteger.TEN);
        }
        return revToSt.multiply(sum);
    }

    // BruteForce Approach
    public int[] BruteForce(String s, int[][] queries) {
        long MOD = 1000000007L;
        long[] arr = new long[queries.length];
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            String dummy = s.substring(a, b+1);
            long num = Long.parseLong(dummy);
            arr[i] = num;
        }
        for (int i = 0; i < ans.length; i++) {
            long num = helper1(arr[i]);
            ans[i] = (int) (num % MOD);
        }
        return ans;
    }
    public long helper1(long n) {
        long rev = 0;
        long sum = 0;
        while (n > 0) {
            if (n % 10 == 0) {
                n /= 10;
            } else {
                rev = (rev * 10) + (n % 10);
                sum += rev % 10;
                n /= 10;
            }
        }
        long revToSt = 0;
        while (rev > 0) {
            revToSt = (revToSt * 10) + (rev % 10);
            rev /= 10;
        }
        return revToSt * sum;
    }
}