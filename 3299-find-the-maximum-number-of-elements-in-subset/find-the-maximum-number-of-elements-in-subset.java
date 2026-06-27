class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Long, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put((long)nums[i], map.getOrDefault((long)nums[i], 0)+1);
        }
        int ans = 1;

        if (map.containsKey(1L)) {
            int ones = map.get(1L);
            if (ones % 2 == 0) ones--;
            ans = Math.max(ans, ones);
        }

        for(Map.Entry<Long, Integer> entry : map.entrySet()){
            int count = 0;
            long curr = entry.getKey();
            if(curr==1) continue;
            while(map.containsKey(curr)){
                if(map.get(curr)==1){
                    count++;
                    break;
                }else{  
                    count+=2;
                    if (curr > 1000000000L / curr) break; // prevent overflow
                    curr = curr*curr;
                }
            }
            if(count%2==0) count--;
            ans = Math.max(count, ans);
        }
        return ans;
    }
}