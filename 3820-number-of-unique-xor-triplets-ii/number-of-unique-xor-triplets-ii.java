class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int maxVal = 0;
        for (int x : nums) maxVal = Math.max(maxVal, x);

        int D = 1;
        while (D <= maxVal) D <<= 1; // all XOR results stay < D

        long[] f = new long[D];
        for (int x : nums) f[x] = 1;      // presence indicator (dupes don't matter)

        long[] Ff = f.clone();
        fwht(Ff);

        // ---- pairwise XOR-achievable set: conv(f, f) ----
        long[] Fpair = new long[D];
        for (int i = 0; i < D; i++) Fpair[i] = Ff[i] * Ff[i];
        fwht(Fpair); // applying fwht again = inverse transform (up to scale D)

        boolean[] pairSet = new boolean[D];
        for (int i = 0; i < D; i++) {
            if (Fpair[i] / D > 0) pairSet[i] = true;
        }

        // ---- triple-wise XOR-achievable set: conv(pairSet, f) ----
        long[] Fp = new long[D];
        for (int i = 0; i < D; i++) Fp[i] = pairSet[i] ? 1 : 0;
        fwht(Fp);

        long[] Ftriple = new long[D];
        for (int i = 0; i < D; i++) Ftriple[i] = Fp[i] * Ff[i];
        fwht(Ftriple);

        int count = 0;
        for (int i = 0; i < D; i++) {
            if (Ftriple[i] / D > 0) count++;
        }
        return count;
    }

    // In-place Walsh–Hadamard Transform (self-inverse up to a factor of n)
    private void fwht(long[] a) {
        int n = a.length;
        for (int len = 1; len < n; len <<= 1) {
            for (int i = 0; i < n; i += (len << 1)) {
                for (int j = i; j < i + len; j++) {
                    long u = a[j], v = a[j + len];
                    a[j] = u + v;
                    a[j + len] = u - v;
                }
            }
        }
    }
}