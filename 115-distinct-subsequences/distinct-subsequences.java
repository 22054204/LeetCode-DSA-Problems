// DP -> Bottom Up Approach
class Solution {
    int[][] dp;
    int m=0;
    int n=0;
    public int numDistinct(String s, String t) {
        m = s.length();
        n = t.length();

        dp = new int[m+1][n+1];
        
        return solve(s, t);
    }
    public int solve(String s, String t){
        //base case 

        dp[m][n] = 1;

        // if(j==n) return 1;
        for(int j=0;j<m;j++){
            dp[j][n] = 1; 
        }

        // if(i==m) return 0;
        for(int i=0;i<n;i++){
            dp[m][i] = 0; 
        }

        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(s.charAt(i)==t.charAt(j)){
                    dp[i][j] = dp[i+1][j+1] + dp[i+1][j];
                }else{
                    dp[i][j] = dp[i+1][j];
                }
            }
        }
        return dp[0][0];
    }
}


/*
    TopDown Approach -> Recursive+Memoization.
    
    class Solution {
        int[][] dp = new int[1001][1001];
        public int numDistinct(String s, String t) {
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
            return solve(s, t, 0, 0);
        }
        public int solve(String s, String t, int i, int j){
            //base case 
            if(j==t.length()){ // j is reaches to end, which means all char matches 
                return 1;
            }
            if(i==s.length()){ // i reaches to end only, which means not char matches from String s with String t
                return 0;
            }

            if(dp[i][j]!=-1){
                return dp[i][j];
            }
            if(s.charAt(i)==t.charAt(j)){
                dp[i][j] = solve(s, t, i+1, j+1)+solve(s, t, i+1, j);
            }else{
                dp[i][j] = solve(s, t, i+1, j);
            }
            return dp[i][j];
        }
    }

*/