class Solution {
    public int sumCounts(int[] nums) {
        int MOD = 1_000_000_007;
        int n = nums.length;
        int B = Math.max(1, (int) Math.sqrt(n));   // block size

        int[] cnt = new int[n];                    // value of each position
        int[] lazy = new int[n / B + 1];           // "+1 note" for each block
        long[] bsum = new long[n / B + 1];         // total of each block
        int[] last = new int[100001];              // last index of each number
        java.util.Arrays.fill(last, -1);

        long s2 = 0, ans = 0;

        for (int i = 0; i < n; i++) {
            int l = last[nums[i]] + 1;             // range to add +1 is l..i
            long old = 0;                          // sum of values in l..i before adding

            for (int k = l; k <= i; ) {
                int b = k / B;
                if (k % B == 0 && k + B - 1 <= i) {   // whole block inside range
                    old += bsum[b];
                    lazy[b]++;
                    bsum[b] += B;
                    k += B;                           // jump over the block
                } else {                              // single element
                    old += cnt[k] + lazy[b];
                    cnt[k]++;
                    bsum[b]++;
                    k++;
                }
            }

            s2 = (s2 + 2 * old + (i - l + 1)) % MOD;  // new sum of squares
            ans = (ans + s2) % MOD;
            last[nums[i]] = i;
        }
        return (int) ans;
    }
}