class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        Integer[] afterSorted = new Integer[n];
        for(int i=0;i<n;i++){
            afterSorted[i] = nums[i];
        }
        Arrays.sort(afterSorted, (a, b) -> {
            int digSum1 = digitSum(a);
            int digSum2 = digitSum(b);
            if(digSum1 != digSum2) return Integer.compare(digSum1, digSum2);
            return Integer.compare(a, b); // if digitSum is Equal
        });
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i], i);
        }
        int minSwaps = 0;
        for(int i=0;i<n;i++){
            int idx_nums = map.get(afterSorted[i]);
            if(idx_nums!=i){
                swap(nums, i, idx_nums);
                minSwaps++;
                map.put(nums[i], i);
                map.put(nums[idx_nums], idx_nums);
            } 
        }
        return minSwaps;
    }
    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public int digitSum(int n){
        int sum = 0;
        while(n>0){
            sum+=n%10;
            n/=10;
        }
        return sum;
    }
}