class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        return Method2(nums, target);
    }
    public int Method2(int[] nums, int target) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            int freq = 0;
            for(int j=i;j<nums.length;j++){
                if (nums[j] == target) freq++;
                int len = j - i + 1;
                if (freq > len / 2) count++;
            }
        }
        return count;
    }
    // Brute Force - TLE for given constraints; suitable only for small arrays.
    public int Method1(int[] nums, int target) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                List<Integer> list = new ArrayList<>();
                for(int k=i;k<=j;k++){
                    list.add(nums[k]);
                }
                if(isValid(list, target)) count++;
            }
        }
        return count;
    }
    private static boolean isValid(List<Integer> list, int target){
        int freq = 0;
        for(int i=0;i<list.size();i++){
            if(list.get(i)==target){
                freq++;
            }
        }
        return freq>list.size()/2;
    }
}