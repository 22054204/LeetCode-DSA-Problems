class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int n = 0;
    Boolean[][] dp;
    public boolean canCross(int[] stones) {
        n = stones.length;

        dp = new Boolean[n+1][n+1];

        if(stones[1]!=1) return false;
        if(n==2) return true;
        int i=0;
        for(int num:stones){
            map.put(num, i);
            i++;
        }
        return solve(stones, map.get(0), 0);
    }

    public boolean solve(int[] stones, int curr_stone_idx, int prev_jump) {
        // Reached the last stone
        if (curr_stone_idx == n - 1) return true;

        // Invalid jump
        if (prev_jump < 0) return false;

        int curr_position = stones[curr_stone_idx];
        
        //Already calculated
        if(dp[curr_stone_idx][prev_jump]!=null) return dp[curr_stone_idx][prev_jump];

        boolean kMinusOne = false;
        boolean k = false;
        boolean kPlusOne = false;

        // K - 1
        if (prev_jump - 1 > 0) {
            int next_position = curr_position + (prev_jump - 1);
            if (map.containsKey(next_position)) {
                kMinusOne = solve(stones, map.get(next_position), prev_jump - 1);
            }
        }
        // K
        if (prev_jump > 0) {
            int next_position = curr_position + prev_jump;
            if (map.containsKey(next_position)) {
                k = solve(stones, map.get(next_position), prev_jump);
            }
        }
        // K + 1
        int next_position = curr_position + (prev_jump + 1);
        if (map.containsKey(next_position)) {
            kPlusOne = solve(stones, map.get(next_position), prev_jump + 1);
        }
        return dp[curr_stone_idx][prev_jump] = kMinusOne || k || kPlusOne;
    }
}