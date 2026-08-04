class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        return Method2(nums, k);
    }
    public int[] Method2(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num:nums){
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        int[] freq = new int[max-min+1];
        for(int num:nums){
            freq[num-min]++;
        }
        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            int maxFreq = 0;
            int idx = -1;
            for(int j=0;j<freq.length;j++){
                if(freq[j]>maxFreq){
                    maxFreq = freq[j];
                    idx = j;
                }
            }
            ans[i] = idx + min;
            freq[idx] = -1;
        }

        return ans;
    }
    public int[] Method1(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        if(n==1) return new int[]{nums[0]};
         for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
         }
         int[]ans = new int[k];
         for(int i=0;i<k;i++){  
            int maxFreq = 0;
            int el = 0;
            for(Map.Entry<Integer,Integer> m : map.entrySet()){
                int key = m.getKey();
                int val = m.getValue();
                if(val>maxFreq){
                    el = key;
                    maxFreq = val;
                }
            }
            map.remove(el);
            ans[i] = el;
         }
         return ans;
    }
}