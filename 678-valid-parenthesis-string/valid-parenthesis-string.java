class Solution {
    Boolean[][] dp;
    int n;
    public boolean checkValidString(String s) {
        n = s.length();
        dp = new Boolean[n+1][n];
        return solve(s, 0, 0);
    }
    public boolean solve(String s, int count, int i){
        if(count<0){
            return false;
        }
        if(i==n){
            return count==0;
        }
        if(dp[count][i]!=null) return dp[count][i];
        if(s.charAt(i)=='('){
            return dp[count][i] = solve(s, count+1, i+1);
        }
        else if(s.charAt(i)==')'){
            return dp[count][i] = solve(s, count-1, i+1);
        }
        return dp[count][i] = solve(s, count+1, i+1) || solve(s, count-1, i+1) || solve(s, count, i+1);
    }
}