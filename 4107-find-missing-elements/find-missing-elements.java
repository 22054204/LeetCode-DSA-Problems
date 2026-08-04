class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int min = 101;
        int max = 0;
        for(int num:nums){
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        int[] freq = new int[max+1];
        for(int num:nums){
            freq[num]++; 
        }
        for(int i=min;i<=max;i++){
            if(freq[i]==0) list.add(i);
        }
        return list;
    }
}