class Solution {
    Boolean[][] dp;
    public boolean checkValidString(String s) {
        int n = s.length();
        dp = new Boolean[n+1][n];
        if(solve(s, 0, 0)) return true;
        return false;
    }
    public boolean solve(String s, int count, int i){
        if(count<0){
            return false;
        }
        if(i==s.length()){
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