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