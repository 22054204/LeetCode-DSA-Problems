class Solution {
    int n=0;
    int[] dp = new int[2001];
    int[] prev;
    int MOD = 1000000007;
    public int distinctSubseqII(String s) {
        Arrays.fill(dp, -1);
        n = s.length();
        prev = new int[n+1];

        int[] lastSeen = new int[26];
        for(int i=1;i<=n;i++){
            int idx = s.charAt(i-1)-'a';
            prev[i] = lastSeen[idx];
            lastSeen[idx] = i;
        }
        return (solve(n)-1+MOD)%MOD;
    }
    public int solve(int n){
        if (n<0) return 0;
        if(n==0) return 1;
        if(dp[n]!=-1) return dp[n];
        long total = (2L*solve(n-1))%MOD;
        long duplicates = (solve(prev[n]-1))%MOD;
        return dp[n] = (int)(total-duplicates+MOD)%MOD;
    }
}