class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        return BS(nums, n);
    }
    private static int BS(int[] nums, int n){
        int start = 0;
        int end = n-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            int leftLen = mid-start;
            int rightLen = end-mid;
            if((mid == 0 || nums[mid] != nums[mid-1]) && (mid == n-1 || nums[mid] != nums[mid+1])){
                return nums[mid];
            }
            if(mid < n-1 && nums[mid]==nums[mid+1]){
                if(leftLen%2==0){
                    start = mid+2;
                }else{
                    end = mid-1;
                }
            }else if(mid > 0 && nums[mid]==nums[mid-1]){
                if(rightLen%2==0){
                    end = mid-2;
                }else{
                    start = mid+1;
                }
            }
        }
        return -1;
    }
}