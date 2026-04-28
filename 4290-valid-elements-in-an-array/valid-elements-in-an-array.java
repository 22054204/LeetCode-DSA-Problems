class Solution {
    public List<Integer> findValidElements(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        res.add(nums[0]);
        int[] left = new int[n];
        int maxele = nums[0];
        for(int i = 1; i < n - 1; i++){
            if(nums[i] > maxele){
                left[i]++;
            }
            maxele = Math.max(maxele, nums[i]);
        }
        int[] right = new int[n];
        int maxright = nums[n - 1];

        for(int i = n - 2; i >= 0; i--){
            if(nums[i] > maxright){
                right[i]++;
            }
            maxright = Math.max(maxright, nums[i]);
        }
        for(int i = 1; i < n - 1; i++){
            if(left[i] > 0 || right[i] > 0){
                res.add(nums[i]);
            }
        }
        if(n != 1){
            res.add(nums[n - 1]);
        }
        return res;
    }
}