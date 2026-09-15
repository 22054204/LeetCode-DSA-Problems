class Solution {
    int size;
    int[][] dp;
    Boolean[][] palindrome;
    public int maxPalindromes(String s, int k) {
        size = s.length();
        dp = new int[size][size];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }
        palindrome = new Boolean[size][size];
        return solve(s, k, 0, 0);
    }
    public int solve(String s, int k, int i, int j){
        if(i>=size){
            return 0;
        }
        if(j>=size){
            return solve(s, k, i+1, i+1);
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(isPalindrome(s, i, j) && j-i+1>=k){ //&& equals to or >= to k
            int take = 1+solve(s, k, j+1, j+1);
            int skip = solve(s, k, i, j+1);
            return dp[i][j] = Math.max(take, skip);
        }
        return dp[i][j] = solve(s, k, i, j+1);
    }
    public boolean isPalindrome(String s, int i, int j){
        if(i>=j) return true;
        if(palindrome[i][j]!=null){
            return palindrome[i][j];
        }
        if(s.charAt(i)!=s.charAt(j)){
            palindrome[i][j] = false;
            return false;
        }
        palindrome[i][j] = isPalindrome(s, i+1, j-1)?true:false;
        return palindrome[i][j];
    }
}