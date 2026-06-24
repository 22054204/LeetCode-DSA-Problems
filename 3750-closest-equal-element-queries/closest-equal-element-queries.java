class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }else{
                map.get(nums[i]).add(i);
            }
        }
        for(int i=0;i<queries.length;i++){
            List<Integer> list = map.get(nums[queries[i]]);

            if(map.get(nums[queries[i]]).size()<2) result.add(-1);
            else{
                int pos = Collections.binarySearch(list, queries[i]);
                
                int prev = list.get((pos - 1 + list.size()) % list.size());
                int next = list.get((pos + 1) % list.size());

                int diff1 = Math.abs(prev - queries[i]);
                int diff2 = Math.abs(next - queries[i]);

                diff1 = Math.min(diff1, nums.length - diff1);
                diff2 = Math.min(diff2, nums.length - diff2);

                result.add(Math.min(diff1, diff2));     
            }
        }
        return result;
    }
}