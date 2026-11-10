class Solution {
    int[] dp;

    public int climbStairs(int n, int[] costs) {
        dp = new int[costs.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        return solve(n, costs, 0);
    }

    public int solve(int n, int[] costs, int i) {
        if (i == n)
            return 0;

        if (dp[i] != Integer.MIN_VALUE)
            return dp[i];

        int cost1 = Integer.MAX_VALUE;
        int cost2 = Integer.MAX_VALUE;
        int cost3 = Integer.MAX_VALUE;

        if (i + 1 <= n) {
            cost1 = costs[i] + 1 + solve(n, costs, i + 1);
        }

        if (i + 2 <= n) {
            cost2 = costs[i + 1] + 4 + solve(n, costs, i + 2);
        }

        if (i + 3 <= n) {
            cost3 = costs[i + 2] + 9 + solve(n, costs, i + 3);
        }

        return dp[i] = Math.min(cost1, Math.min(cost2, cost3));
    }
}
