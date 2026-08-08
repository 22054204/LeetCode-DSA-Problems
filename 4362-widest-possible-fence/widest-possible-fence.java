class Solution {
    public int maximumWidth(int[] planks) {
        // Frequency of each distinct height.
        Map<Long, Integer> freq = new HashMap<>();
        for (int p : planks) freq.merge((long) p, 1, Integer::sum);

        int k = freq.size();
        long[] vals = new long[k];
        int[] cnt = new int[k];
        int idx = 0;
        for (Map.Entry<Long, Integer> e : freq.entrySet()) {
            vals[idx] = e.getKey();
            cnt[idx] = e.getValue();
            idx++;
        }

        // pairs.get(h) = max number of disjoint plank-pairs summing to h
        Map<Long, Integer> pairs = new HashMap<>();

        // Pairs formed from two DIFFERENT planks of the SAME height v:
        // floor(cnt[v] / 2) such pairs, each worth height 2v.
        for (int i = 0; i < k; i++) {
            int half = cnt[i] / 2;
            if (half > 0) {
                pairs.merge(vals[i] * 2, half, Integer::sum);
            }
        }

        // Pairs formed from two planks of DIFFERENT heights p < q:
        // min(cnt[p], cnt[q]) such pairs, each worth height p+q.
        // These groupings never conflict with each other (different value
        // pairs use disjoint sets of planks), so contributions simply add.
        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < k; j++) {
                int m = Math.min(cnt[i], cnt[j]);
                pairs.merge(vals[i] + vals[j], m, Integer::sum);
            }
        }

        int best = 1; // a lone plank is always a valid fence of width 1

        // Candidate heights that are existing plank values (singles + any pairs hitting them).
        for (int i = 0; i < k; i++) {
            int total = cnt[i] + pairs.getOrDefault(vals[i], 0);
            if (total > best) best = total;
        }

        // Candidate heights that only arise as pair sums.
        for (Map.Entry<Long, Integer> e : pairs.entrySet()) {
            int total = freq.getOrDefault(e.getKey(), 0) + e.getValue();
            if (total > best) best = total;
        }

        return best;
    }
}



/* O(n^3) brute force
class Solution {
    public int maximumWidth(int[] planks) {
        // Eg1 - [1,3,2,5,7,5,4,2,1]
        //[1,1,2,2,3,4,5,5,7]
        //1->2((1,1)), 2->3((1,1),(2),(2)), 3->3((1,2),(1,2),(3)), 
        //4->3((1,3),(2,2)(4)), 5->4((1,4),(5),(5),(3,2)).... ans so on ... 
        //where 5 has 4 which is max return 4;

        int n = planks.length;
        Arrays.sort(planks);
        Set<Long> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add((long)planks[i]);
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                set.add((long)planks[i] + planks[j]);
            }
        }
        int ans = 0;
        for(long target : set){
            boolean[] used = new boolean[n];
            int width = 0;
            // Use all planks already equal to target
            for(int i=0;i<n;i++){
                if(planks[i]==target){
                    used[i]=true;
                    width++;
                }
            }
            // Two pointers for remaining planks
            int l=0,r=n-1;
            while(l<r){
                while(l<n && used[l]) l++;
                while(r>=0 && used[r]) r--;
                if(l>=r) break;
                long sum=(long)planks[l]+planks[r];
                if(sum==target){
                    width++;
                    l++;
                    r--;
                }else if(sum<target){
                    l++;
                }else{
                    r--;
                }
            }
            ans=Math.max(ans,width);
        }
        return ans;
    }
}
*/