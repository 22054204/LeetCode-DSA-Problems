class Solution {
    int[][] dp;
    int m=0;
    int n=0;
    public int numDistinct(String s, String t) {
        m = s.length();
        n = t.length();

        dp = new int[m+1][n+1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
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