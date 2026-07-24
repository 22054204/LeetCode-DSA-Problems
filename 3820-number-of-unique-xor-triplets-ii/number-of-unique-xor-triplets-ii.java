import java.util.*;

class Solution {
    public int uniqueXorTriplets(int[] nums) {
        boolean[] present = new boolean[1501];
        int maxVal = 0;
        for (int x : nums) {
            present[x] = true;
            maxVal = Math.max(maxVal, x);
        }

        List<Integer> uniqueVals = new ArrayList<>();
        for (int v = 1; v <= maxVal; v++) if (present[v]) uniqueVals.add(v);
        int m = uniqueVals.size();

        int D = 1;
        while (D <= maxVal) D <<= 1;

        boolean[] pairSet = new boolean[D];
        for (int i = 0; i < m; i++) {
            int ui = uniqueVals.get(i);
            for (int j = i; j < m; j++) {
                pairSet[ui ^ uniqueVals.get(j)] = true;
            }
        }

        boolean[] tripleSet = new boolean[D];
        for (int a = 0; a < D; a++) {
            if (!pairSet[a]) continue;
            for (int u : uniqueVals) {
                tripleSet[a ^ u] = true;
            }
        }

        int count = 0;
        for (boolean b : tripleSet) if (b) count++;
        return count;
    }
}