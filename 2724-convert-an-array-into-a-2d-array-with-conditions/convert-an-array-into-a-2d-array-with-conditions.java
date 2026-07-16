class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] freq = new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            freq[nums[i]]++;
        }
        while(true){
            boolean allZeros = true;
            List<Integer> list = new ArrayList<>();
            for(int i=1;i<freq.length;i++){
                if (freq[i] > 0) {
                    list.add(i);
                    freq[i]--;
                    allZeros = false;
                }
            }
            if(!list.isEmpty()) result.add(list);
            if(allZeros) break;
        }
        return result;
    }
}