class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
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

        int[] power10 = new int[s.length()+1];
        power10[0] = 1;
        for(int i=1;i<=s.length();i++){
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
}












