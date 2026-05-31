import java.util.*;

class Solution {
    public int[] maximumMEX(int[] nums){
        return Better(nums);
    }
    public int[] Better(int[] nums) {
        int n = nums.length;

        int[] freq = new int[n + 1];
        for(int i=0;i<n;i++){
            if(nums[i] <= n){
                freq[nums[i]]++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        int i = 0;
        while(i < n){
            int mex = 0;
            while(mex <= n && freq[mex] > 0){
                mex++;
            }
            if(mex == 0){
                ans.add(0);
                if(nums[i] <= n){
                    freq[nums[i]]--;
                }
                i++;
                continue;
            }
            boolean[] seen = new boolean[mex];
            int need = mex;
            int j = i;
            while(j < n){
                if(nums[j] < mex && !seen[nums[j]]){
                    seen[nums[j]] = true;
                    need--;
                }
                if(nums[j] <= n){
                    freq[nums[j]]--;
                }
                if(need == 0){
                    break;
                }
                j++;
            }
            ans.add(mex);
            i = j + 1;
        }
        int[] res = new int[ans.size()];
        for(int k=0;k<ans.size();k++){
            res[k] = ans.get(k);
        }
        return res;
    }

    // cause TLE - 990 / 999 testcases passed
    public int[] BruteForce(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        List<Integer> result = new ArrayList<>();
        while(!list.isEmpty()){
            int mex = findMEX(list);
            if(mex == 0){
                result.add(0);
                list.remove(0);
                continue;
            }
            int k = findK(list,mex);
            result.add(mex);
            for(int i=0;i<k;i++){
                list.remove(0);
            }
        }

        int[] ans = new int[result.size()];
        for(int i=0;i<result.size();i++){
            ans[i] = result.get(i);
        }
        return ans;
    }
    private static int findMEX(List<Integer> list){
        int mex = 0;
        while(list.contains(mex)){
            mex++;
        }
        return mex;
    }
    private static int findK(List<Integer> list,int mex){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<list.size();i++){
            if(list.get(i) < mex){
                set.add(list.get(i));
            }
            if(set.size() == mex){
                return i + 1;
            }
        }
        return list.size();
    }
}