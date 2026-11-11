class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long ans = 0;

        long take1 = (long)cost1 + cost2;
        long take2 = costBoth;

        long common = Math.min(need1, need2);

        ans += common * Math.min(take1, take2);

        need1 -= common;
        need2 -= common;

        ans += (long)need1 * Math.min(cost1, costBoth);
        ans += (long)need2 * Math.min(cost2, costBoth);

        return ans;
    }
}