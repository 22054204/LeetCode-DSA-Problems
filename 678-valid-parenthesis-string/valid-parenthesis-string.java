class Solution {
    Boolean[][][] dp;
    public boolean checkValidString(String s) {
        int n = s.length();
        dp = new Boolean[n+1][n+1][n];
        if(solve(s, 0, 0, 0)) return true;
        return false;
    }
    public boolean solve(String s, int left, int right, int i){
        if(right>left){
            return false;
        }
        if(i==s.length()){
            return left==right;
        }
        if(dp[left][right][i]!=null) return dp[left][right][i];
        if(s.charAt(i)=='('){
            return dp[left][right][i] = solve(s, left+1, right, i+1);
        }
        else if(s.charAt(i)==')'){
            return dp[left][right][i] = solve(s, left, right+1, i+1);
        }
        return dp[left][right][i] = solve(s, left+1, right, i+1) || solve(s, left, right+1, i+1) || solve(s, left, right, i+1);
    }
}